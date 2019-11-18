package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonConstants {

	public static final String USER_JSON_PATH = "/user/user.json";

	public static final String USER_OUTPUT_PATH = "/user/output";

	public static final String BUSINESS_JSON_PATH = "/business/business.json";

	public static final String BUSINESS_OUTPUT_PATH = "/business/output";

	public static final String PROFILE_INPUT_PATH = "/part-r-00000";

	public static final String PROFILE_OUTPUT_PATH = "/profile";

	public static final String DISTINCT_NAMES_PATH = "/distinctNames";

	public static final String TOTAL_NAMES_PATH = "/totalNames";

	public static final String TOTAL_RESTAURANTS_PATH = "/totalRestaurants";

	public static final String STARS_PATH = "/stars";

	public static final String DISTINCT_CATEGORIES_PATH = "/distinctCategories";

	public static final String CATEGORIES_PATH = "/categories";

	public static final String TOTAL_NAMES = "Total Names:";

	public static final String TOTAL_RESTAURANTS = "Total Restaurants:";

	public static final String USER_NAME_SIZE = "User Name Size:";

	public static final String RESTAURANT_NAME_SIZE = "Restaurants Name Size:";

	public static final String CITY_SIZE = "City Size:";

	public static final String STATE_SIZE = "State Size:";

	public static final String CATEGORIES_SIZE = "Number of Categories:";

	public static final String CATEGORY_SIZE = "Category Size:";

	public static final String MAX = "Max ";

	public static final String MIN = "Min ";

	public static final String DISTINCT_NAMES = "Distinct Names:";

	public static final String DISTINCT_CATEGORIES = "Distinct Categories:";

	public static final String DELIMITER = ",";

	public static final List<String> CITIES_TO_MATCH = new ArrayList<>(Arrays.asList("las vegas"));

	public static final List<String> CITY_PREFIX = new ArrayList<>(Arrays.asList("north", "south"));

	public static final List<String> RESTAURANT_NAME_EXTRA = new ArrayList<>(
			Arrays.asList("family", "restaurant", "bar", "grill", "las vegas", "foods"));

	public static final List<String> LOCATION_NAME_EXTRA = new ArrayList<>(Arrays.asList("blvd", "rd", "ave", "pkwy",
			"dr", "ste", "ln", "parkway", "avenue", "boulevard", "suite", "road", "street", "drive", "st"));

	public static final List<String> STATES_TO_MATCH = new ArrayList<>(Arrays.asList("nv"));

	public static final List<String> CATEGORIES_TO_MATCH = new ArrayList<>(Arrays.asList("restaurants"));

	public static final Map<String, String> CATEGORIES_TO_REPLACE;

	static {
		CATEGORIES_TO_REPLACE = new HashMap<>();
		CATEGORIES_TO_REPLACE.put("beer bar", "beer");
		CATEGORIES_TO_REPLACE.put("beer garden", "beer");
		CATEGORIES_TO_REPLACE.put("beer gardens", "beer");
		CATEGORIES_TO_REPLACE.put("american (new)", "american");
		CATEGORIES_TO_REPLACE.put("american (traditional)", "american");
		CATEGORIES_TO_REPLACE.put("japanese curry", "japanese");
		CATEGORIES_TO_REPLACE.put("irish pub", "irish");
		Collections.unmodifiableMap(CATEGORIES_TO_REPLACE);
	}

	public static final List<String> CATEGORIES_TO_REMOVE = new ArrayList<>(Arrays.asList("restaurants", "food",
			"acupuncture", "adult entertainment", "air duct cleaning", "aircraft repairs", "airport shuttles",
			"airport terminals", "airports", "airsoft", "amateur sports teams", "amusement parks", "antiques",
			"appliances", "appliances & repair", "aquarium services", "aquariums", "arcades", "art classes",
			"art galleries", "art supplies", "arts & crafts", "arts & entertainment", "audio/visual equipment rental",
			"auto customization", "auto glass services", "auto insurance", "auto parts & supplies", "auto repair",
			"automotive", "baby gear & furniture", "bangladeshi", "bankruptcy law", "barbers", "beauty & spas",
			"bingo halls", "blow dry/out services", "body shops", "books", "bookstores", "bowling", "brasseries",
			"brazilian jiu-jitsu", "british", "business consulting", "butcher", "cabaret", "cannabis dispensaries",
			"car dealers", "car rental", "car wash", "car window tinting", "caribbean", "casinos", "caterers", "cinema",
			"colleges & universities", "comedy clubs", "commercial truck repair", "contractors", "convenience stores",
			"conveyor belt sushi", "cosmetic dentists", "cosmetics & beauty supply", "country clubs",
			"country dance halls", "couriers & delivery services", "courthouses", "cultural center", "dance clubs",
			"day spas", "delicatessen", "dentists", "department stores", "dinner theater", "discount store",
			"divorce & family law", "djs", "doctors", "drugstores", "dry cleaning", "eatertainment", "education",
			"electricians", "electronics", "empanadas", "employment agencies", "engraving", "ethical grocery",
			"ethnic grocery", "event planning & services", "eyebrow services", "eyelash service", "family practice",
			"farmers market", "fashion", "feng shui", "festivals", "financial services", "fireplace services",
			"fitness & instruction", "florists", "flowers & gifts", "food delivery services", "food tours",
			"fur clothing", "furniture rental", "furniture repair", "furniture stores", "gas stations", "gift shops",
			"golf", "grilling equipment", "grocery", "gun/rifle ranges", "gyms", "hair extensions", "hair removal",
			"hair salons", "hair stylists", "hats", "health & medical", "health markets",
			"heating & air conditioning/hvac", "herbs & spices", "historical tours", "hobby shops", "home & garden",
			"home cleaning", "home decor", "home services", "home window tinting", "hostels", "hot pot",
			"hotels & travel", "ice delivery", "immigration law", "imported food", "insurance", "interior design",
			"international grocery", "internet cafes", "jazz & blues", "jewelry", "karaoke", "kids activities",
			"kitchen & bath", "kosher", "landmarks & historical buildings", "laser hair removal", "laundry services",
			"lawyers", "lighting fixtures & equipment", "limos", "local fish stores", "local flavor", "local services",
			"mags", "mailbox centers", "makeup artists", "martial arts", "masonry/concrete", "massage",
			"massage therapy", "meat shops", "medical centers", "meditation centers", "men's clothing",
			"metal fabricators", "mobile phones", "mortgage brokers", "museums", "music & video", "music venues",
			"musicians", "nail salons", "nail technicians", "new mexican cuisine", "newspapers & magazines",
			"nicaraguan", "nutritionists", "occupational therapy", "office equipment", "oil change stations",
			"organic stores", "outdoor furniture stores", "outlet stores", "paint & sip", "paint-your-own pottery",
			"parks", "party & event planning", "party bus rentals", "party equipment rentals", "party supplies",
			"pasta shops", "performing arts", "persian/iranian", "personal assistants", "personal chefs",
			"personal injury law", "personal shopping", "pet adoption", "pet services", "pet stores", "pets",
			"pharmacy", "photo booth rentals", "photography stores & services", "physical therapy", "piano bars",
			"pilates", "playgrounds", "plumbing", "poke", "police departments", "pool & hot tub service", "pool halls",
			"printing services", "professional services", "public services & government", "real estate",
			"real estate services", "recreation centers", "reflexology", "rehabilitation center", "resorts",
			"restaurant supplies", "rv parks", "screen printing", "seafood markets", "security services",
			"security systems", "septic services", "service stations", "shaved ice", "shaved snow", "shopping",
			"shopping centers", "signmaking", "singaporean", "skating rinks", "skin care", "skydiving", "soba",
			"social clubs", "special education", "specialty food", "sporting goods", "sports bars", "sports wear",
			"stadiums & arenas", "street art", "street vendors", "strip clubs", "studio taping", "swimming pools",
			"tabletop games", "tennis", "themed cafes", "ticket sales", "tickets", "tobacco shops", "tours", "towing",
			"trainers", "transmission repair", "transportation", "travel services", "trophy shops", "truck rental",
			"vehicle wraps", "venues & event spaces", "veterinarians", "videos & video game rental",
			"vitamins & supplements", "walking tours", "water heater installation/repair", "water stores", "waxing",
			"wedding chapels", "wedding planning", "weight loss centers", "wholesale stores", "wholesalers", "wigs",
			"windshield installation & repair", "wine & spirits", "wineries", "women's clothing", "yelp events", "yoga",
			"zoos"));
}