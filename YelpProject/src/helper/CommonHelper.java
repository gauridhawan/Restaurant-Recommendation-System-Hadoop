package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonHelper {

	private static ObjectMapper mapper = new ObjectMapper();

	public static boolean isNotBlank(String arg) {
		return !isBlank(arg);
	}

	public static boolean isBlank(String arg) {
		return arg == null || arg.trim().isEmpty();
	}

	public static List<String> getListFromString(String arg, List<String> doNotAdd, Map<String, String> replaceWith) {
		List<String> ans = new ArrayList<>();
		List<String> fromArg = getListFromString(arg);
		if (fromArg != null && !fromArg.isEmpty()) {
			for (String key : fromArg) {
				String keyToUse = key.toLowerCase().trim();
				if (!doNotAdd.contains(keyToUse)) {
					if (replaceWith.containsKey(keyToUse)) {
						ans.add(replaceWith.get(keyToUse));
					} else {
						ans.add(key.trim());
					}
				}
			}
		}
		return ans;
	}

	public static List<String> getListFromString(String arg) {
		return new ArrayList<String>(Arrays.asList(arg.split(CommonConstants.DELIMITER)));
	}

	public static String getStringFromList(List<String> list) {
		if (list == null || list.isEmpty())
			return "";
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < list.size() - 1; i++) {
			str.append(list.get(i));
			str.append(CommonConstants.DELIMITER);
		}
		str.append(list.get(list.size() - 1));
		return str.toString();
	}

	public static String getStringFromMap(Map<String, Object> map) {
		if (map == null || map.isEmpty())
			return "";
		StringBuilder str = new StringBuilder();
		for (String key : map.keySet()) {
			str.append(key);
			str.append(":");
			str.append(map.get(key));
			str.append(",");
		}
		String result = str.toString();
		return result.substring(0, result.length() - 1);
	}

	public static String removeSubstrings(String text, List<String> textToRemove) {
		if (isNotBlank(text) && !textToRemove.isEmpty()) {
			text = text.toLowerCase();
			for (String t : textToRemove) {
				text = text.replace(t, "").trim();
			}
		}
		return text;
	}

	public static String removeRegex(String text, String regex, List<String> textToRemove) {
		if (isNotBlank(text) && isNotBlank(regex)) {
			text = text.toLowerCase();
			boolean isChar = false;
			int k = text.length();
			for (int i = 0; i < text.length(); i++) {
				if (Character.isLetter(text.charAt(i))) {
					isChar = true;
				} else if (isChar && Character.isDigit(text.charAt(i))) {
					k = i;
					break;
				}
			}
			text = text.substring(0, k);
			int c = text.length();
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == ',') {
					c = i;
					break;
				}
			}

			text = text.substring(0, c);
			for (String t : textToRemove) {
				if (text.contains(t)) {
					int i = text.indexOf(t);
					text = text.substring(0, i);
				}
			}
			text = text.replaceAll(regex, "");
			text = text.trim();
		}
		return text;
	}

	public static void checkInput(String[] args) {
		if (args == null || args.length != 2 || isBlank(args[0]) || isBlank(args[1])) {
			System.err.println("Usage: User <input path> <output path>");
			System.exit(-1);
		}
	}

	public static void checkInput(String arg) {
		if (isBlank(arg)) {
			System.err.println("String is empty");
			System.exit(-1);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getJsonFromString(String json, T t) {
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return (T) mapper.readValue(json, t.getClass());
		} catch (JsonProcessingException e) {
			System.err.println("Error while reading JSON: " + e);
			System.out.println("Skipping Record!");
			return null;
		}
	}

	public static <T> String getStringFromJson(T t) {
		try {
			return mapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			System.err.println("Error while processing JSON: " + e);
			System.out.println("Skipping Record!");
			return null;
		}
	}

	public static int getTotalCount(Iterable<IntWritable> values) {
		int count = 0;
		for (IntWritable value : values) {
			count = count + value.get();
		}
		return count;
	}
}