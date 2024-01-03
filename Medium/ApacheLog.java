import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApacheLog {

    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */

//  public static String findTopIpaddress(String[] lines) {
//    // Your code goes here
//	HashMap<String, Integer> hm = new HashMap<String, Integer>();
//	for(String line : lines) {
//		if(line.)
//	}
//    return "10.0.0.1";
//  }

    static String IPADDRESS_PATTERN = "(\\d{1,3}\\.){3}\\d{1,3}";
public static String findTopIpaddress(String[] lines) {

    // String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
    if (lines == null || lines.length == 0) {
        System.out.println("Invalid input...");
        return null;
    }
    Pattern pattern = Pattern.compile(IPADDRESS_PATTERN, Pattern.CASE_INSENSITIVE);
    Map<String, Integer> ipAddressCountMap = new HashMap<>();
    Arrays.stream(lines).forEach(line -> {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String ipAddress = matcher.group();// line.split(" ")[0];
//            Integer count = ipAddressCountMap.getOrDefault(ipAddress, 0) + 1;
//            ipAddressCountMap.put(ipAddress, count);
            ipAddressCountMap.compute(ipAddress,((s, val) -> val==null?1: val+1 ));
        } else {
            System.out.println("Invalid IP address while reading line  -- " + line);
        }
    });

    try {
        ipAddressCountMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
                .orElse(null).getKey();
        Integer topCount = ipAddressCountMap.values().stream().mapToInt(v -> v).max()
                .orElseThrow(IllegalArgumentException::new);
        return ipAddressCountMap.entrySet().stream().filter(x -> x.getValue() == topCount).
                map(Map.Entry::getKey).collect(Collectors.joining());
                //.collect(Collectors.toCollection(HashSet::new));
    } catch (IllegalArgumentException exc) {
        System.out.println("Couldn't find a Valid IP Address in any of the lines!! ");
        return null;
    }
}




    public static void main(String[] args) {

        String lines[] = new String[]{
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                " - log entry 2 213 10.0.0.4",
                "10.0.0.2 - log entry 133132"};
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }

}