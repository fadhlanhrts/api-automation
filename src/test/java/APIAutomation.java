import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.module.jsv.JsonSchemaValidator;


public class APIAutomation {

    public static String schema = "{\n" +
            "    \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
            "    \"type\": \"array\",\n" +
            "    \"items\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"id\": {\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"name\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"tagline\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"first_brewed\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"description\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"image_url\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"abv\": {\n" +
            "          \"type\": [\n" +
            "            \"number\",\n" +
            "            \"integer\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"ibu\": {\n" +
            "          \"type\": [\n" +
            "            \"integer\",\n" +
            "            \"number\",\n" +
            "            \"null\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"target_fg\": {\n" +
            "          \"type\": \"integer\",\n" +
            "          \"enum\": [\n" +
            "            1010,\n" +
            "            1007,\n" +
            "            1012,\n" +
            "            1027,\n" +
            "            1005,\n" +
            "            1017,\n" +
            "            1020,\n" +
            "            1013,\n" +
            "            1025,\n" +
            "            1014,\n" +
            "            1030,\n" +
            "            1000\n" +
            "          ]\n" +
            "        },\n" +
            "        \"target_og\": {\n" +
            "          \"type\": [\n" +
            "            \"integer\",\n" +
            "            \"number\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"ebc\": {\n" +
            "          \"type\": [\n" +
            "            \"integer\",\n" +
            "            \"null\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"srm\": {\n" +
            "          \"type\": [\n" +
            "            \"integer\",\n" +
            "            \"number\",\n" +
            "            \"null\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"ph\": {\n" +
            "          \"type\": [\n" +
            "            \"number\",\n" +
            "            \"null\",\n" +
            "            \"integer\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"attenuation_level\": {\n" +
            "          \"type\": [\n" +
            "            \"integer\",\n" +
            "            \"number\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"volume\": {\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"value\": {\n" +
            "              \"type\": \"integer\",\n" +
            "              \"enum\": [\n" +
            "                20\n" +
            "              ]\n" +
            "            },\n" +
            "            \"unit\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"enum\": [\n" +
            "                \"litres\"\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"required\": [\n" +
            "            \"value\",\n" +
            "            \"unit\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"boil_volume\": {\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"value\": {\n" +
            "              \"type\": \"integer\",\n" +
            "              \"enum\": [\n" +
            "                25\n" +
            "              ]\n" +
            "            },\n" +
            "            \"unit\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"enum\": [\n" +
            "                \"litres\"\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"required\": [\n" +
            "            \"value\",\n" +
            "            \"unit\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"method\": {\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"mash_temp\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"temp\": {\n" +
            "                    \"type\": \"object\",\n" +
            "                    \"properties\": {\n" +
            "                      \"value\": {\n" +
            "                        \"type\": \"integer\",\n" +
            "                        \"enum\": [\n" +
            "                          64,\n" +
            "                          69,\n" +
            "                          60,\n" +
            "                          65,\n" +
            "                          72,\n" +
            "                          78,\n" +
            "                          66,\n" +
            "                          67,\n" +
            "                          68\n" +
            "                        ]\n" +
            "                      },\n" +
            "                      \"unit\": {\n" +
            "                        \"type\": \"string\",\n" +
            "                        \"enum\": [\n" +
            "                          \"celsius\"\n" +
            "                        ]\n" +
            "                      }\n" +
            "                    },\n" +
            "                    \"required\": [\n" +
            "                      \"value\",\n" +
            "                      \"unit\"\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  \"duration\": {\n" +
            "                    \"type\": [\n" +
            "                      \"integer\",\n" +
            "                      \"null\"\n" +
            "                    ]\n" +
            "                  }\n" +
            "                },\n" +
            "                \"required\": [\n" +
            "                  \"temp\",\n" +
            "                  \"duration\"\n" +
            "                ]\n" +
            "              }\n" +
            "            },\n" +
            "            \"fermentation\": {\n" +
            "              \"type\": \"object\",\n" +
            "              \"properties\": {\n" +
            "                \"temp\": {\n" +
            "                  \"type\": \"object\",\n" +
            "                  \"properties\": {\n" +
            "                    \"value\": {\n" +
            "                      \"type\": \"integer\",\n" +
            "                      \"enum\": [\n" +
            "                        19,\n" +
            "                        18,\n" +
            "                        21,\n" +
            "                        9,\n" +
            "                        10,\n" +
            "                        22,\n" +
            "                        11,\n" +
            "                        17,\n" +
            "                        20\n" +
            "                      ]\n" +
            "                    },\n" +
            "                    \"unit\": {\n" +
            "                      \"type\": \"string\",\n" +
            "                      \"enum\": [\n" +
            "                        \"celsius\"\n" +
            "                      ]\n" +
            "                    }\n" +
            "                  },\n" +
            "                  \"required\": [\n" +
            "                    \"value\",\n" +
            "                    \"unit\"\n" +
            "                  ]\n" +
            "                }\n" +
            "              },\n" +
            "              \"required\": [\n" +
            "                \"temp\"\n" +
            "              ]\n" +
            "            },\n" +
            "            \"twist\": {\n" +
            "              \"type\": [\n" +
            "                \"null\",\n" +
            "                \"string\"\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"required\": [\n" +
            "            \"mash_temp\",\n" +
            "            \"fermentation\",\n" +
            "            \"twist\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"ingredients\": {\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"malt\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"enum\": [\n" +
            "                      \"Maris Otter Extra Pale\",\n" +
            "                      \"Caramalt\",\n" +
            "                      \"Munich\",\n" +
            "                      \"Propino Pale Malt\",\n" +
            "                      \"Wheat Malt\",\n" +
            "                      \"Propino Pale Malt for kettle souring\",\n" +
            "                      \"Acidulated Malt for kettle souring\",\n" +
            "                      \"Extra Pale\",\n" +
            "                      \"Dark Crystal\",\n" +
            "                      \"Lager Malt\",\n" +
            "                      \"Wheat\",\n" +
            "                      \"Chocolate\",\n" +
            "                      \"Carafa Special Malt Type 3\",\n" +
            "                      \"Acidulated Malt\",\n" +
            "                      \"Flaked Oats\",\n" +
            "                      \"Crystal\",\n" +
            "                      \"Peated Malt\",\n" +
            "                      \"Amber\",\n" +
            "                      \"Brown\",\n" +
            "                      \"Crystal 150\",\n" +
            "                      \"Pale Ale\",\n" +
            "                      \"Smoked Weyermann\",\n" +
            "                      \"Carafa Special Malt Type 1\",\n" +
            "                      \"Dark Crystal 350-400\",\n" +
            "                      \"Pale Ale - Tipple\",\n" +
            "                      \"Extra Pale - Spring Blend\",\n" +
            "                      \"Roasted Barley\",\n" +
            "                      \"Smoked Malt\"\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  \"amount\": {\n" +
            "                    \"type\": \"object\",\n" +
            "                    \"properties\": {\n" +
            "                      \"value\": {\n" +
            "                        \"type\": [\n" +
            "                          \"number\",\n" +
            "                          \"integer\"\n" +
            "                        ]\n" +
            "                      },\n" +
            "                      \"unit\": {\n" +
            "                        \"type\": \"string\",\n" +
            "                        \"enum\": [\n" +
            "                          \"kilograms\"\n" +
            "                        ]\n" +
            "                      }\n" +
            "                    },\n" +
            "                    \"required\": [\n" +
            "                      \"value\",\n" +
            "                      \"unit\"\n" +
            "                    ]\n" +
            "                  }\n" +
            "                },\n" +
            "                \"required\": [\n" +
            "                  \"name\",\n" +
            "                  \"amount\"\n" +
            "                ]\n" +
            "              }\n" +
            "            },\n" +
            "            \"hops\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"enum\": [\n" +
            "                      \"Fuggles\",\n" +
            "                      \"First Gold\",\n" +
            "                      \"Cascade\",\n" +
            "                      \"Amarillo\",\n" +
            "                      \"Simcoe\",\n" +
            "                      \"Motueka\",\n" +
            "                      \"Bramling Cross\",\n" +
            "                      \"Centennial\",\n" +
            "                      \"Saaz\",\n" +
            "                      \"Nelson Sauvin\",\n" +
            "                      \"Peppercorns\",\n" +
            "                      \"Tomahawk\",\n" +
            "                      \"Magnum\",\n" +
            "                      \"Hersbrucker\",\n" +
            "                      \"Honey\",\n" +
            "                      \"Lactose\",\n" +
            "                      \"Citra\",\n" +
            "                      \"Columbus Extract\",\n" +
            "                      \"Columbus\",\n" +
            "                      \"Willamette\",\n" +
            "                      \"Galena\",\n" +
            "                      \"Hop Extract\",\n" +
            "                      \"Chinook\",\n" +
            "                      \"Mt.Hood\",\n" +
            "                      \"Challenger\",\n" +
            "                      \"Waimea\",\n" +
            "                      \"Ahtanum\",\n" +
            "                      \"Crystal\",\n" +
            "                      \"Sorachi Ace\"\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  \"amount\": {\n" +
            "                    \"type\": \"object\",\n" +
            "                    \"properties\": {\n" +
            "                      \"value\": {\n" +
            "                        \"type\": [\n" +
            "                          \"integer\",\n" +
            "                          \"number\"\n" +
            "                        ]\n" +
            "                      },\n" +
            "                      \"unit\": {\n" +
            "                        \"type\": \"string\",\n" +
            "                        \"enum\": [\n" +
            "                          \"grams\"\n" +
            "                        ]\n" +
            "                      }\n" +
            "                    },\n" +
            "                    \"required\": [\n" +
            "                      \"value\",\n" +
            "                      \"unit\"\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  \"add\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"enum\": [\n" +
            "                      \"start\",\n" +
            "                      \"middle\",\n" +
            "                      \"end\",\n" +
            "                      \"dry hop\"\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  \"attribute\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"enum\": [\n" +
            "                      \"bitter\",\n" +
            "                      \"flavour\",\n" +
            "                      \"aroma\",\n" +
            "                      \"Flavour\"\n" +
            "                    ]\n" +
            "                  }\n" +
            "                },\n" +
            "                \"required\": [\n" +
            "                  \"name\",\n" +
            "                  \"amount\",\n" +
            "                  \"add\",\n" +
            "                  \"attribute\"\n" +
            "                ]\n" +
            "              }\n" +
            "            },\n" +
            "            \"yeast\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"enum\": [\n" +
            "                \"Wyeast 1056 - American Ale™\",\n" +
            "                \"Wyeast 2007 - Pilsen Lager™\",\n" +
            "                \"Wyeast 3711 - French Saison™\",\n" +
            "                \"Wyeast 3522 - Belgian Ardennes™\",\n" +
            "                \"Saflager S189\",\n" +
            "                \"Wyeast 1272 - American Ale II™\",\n" +
            "                \"Wyeast 3333 - German Wheat™\",\n" +
            "                \"Wyeast 3638 - Bavarian Wheat™\"\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"required\": [\n" +
            "            \"malt\",\n" +
            "            \"hops\",\n" +
            "            \"yeast\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"food_pairing\": {\n" +
            "          \"type\": \"array\",\n" +
            "          \"items\": {\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"brewers_tips\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"contributed_by\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"enum\": [\n" +
            "            \"Sam Mason <samjbmason>\",\n" +
            "            \"Ali Skinner <AliSkinner>\"\n" +
            "          ]\n" +
            "        }\n" +
            "      },\n" +
            "      \"required\": [\n" +
            "        \"id\",\n" +
            "        \"name\",\n" +
            "        \"tagline\",\n" +
            "        \"first_brewed\",\n" +
            "        \"description\",\n" +
            "        \"image_url\",\n" +
            "        \"abv\",\n" +
            "        \"ibu\",\n" +
            "        \"target_fg\",\n" +
            "        \"target_og\",\n" +
            "        \"ebc\",\n" +
            "        \"srm\",\n" +
            "        \"ph\",\n" +
            "        \"attenuation_level\",\n" +
            "        \"volume\",\n" +
            "        \"boil_volume\",\n" +
            "        \"method\",\n" +
            "        \"ingredients\",\n" +
            "        \"food_pairing\",\n" +
            "        \"brewers_tips\",\n" +
            "        \"contributed_by\"\n" +
            "      ]\n" +
            "    }\n" +
            "  }";
    @Test
    public static void getTwentyBeers() {
        get("https://api.punkapi.com/v2/beers?page=2&per_page=20").then().assertThat()
                .body("size()", is(20));

    }

    @Test
    public static void getFiveBeers() {
        get("https://api.punkapi.com/v2/beers?page=2&per_page=5").then().assertThat()
                .body("size()", is(5));
    }

    @Test
    public static void getOneBeer() {
        get("https://api.punkapi.com/v2/beers?page=2&per_page=1").then().assertThat()
                .body("size()", is(1));
    }

    @Test
    public static void getJSONSchema() {
        get("https://api.punkapi.com/v2/beers?page=2&per_page=1").then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(schema));
    }

    @Test
    public static void getNameFromJSON() {

        Response res = get("https://api.punkapi.com/v2/beers?page=2&per_page=1");
        JsonPath jp = new JsonPath(res.asString());
        int len = jp.getInt("size()");
        for (int i = 0; i < len; i++) {
            System.out.println(jp.getString("name"));
        }

    }
}
