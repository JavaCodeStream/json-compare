package edu.sandip.javacodestream.json;

import org.apache.commons.collections4.CollectionUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Arrays;
import java.util.List;

/**
 * Provides utility functions to perform Comparison between 2 JSON Strings / JSONObjects /JSONArrays
 * Implementation does a deep comparison on 2 given JSON.
 * Considerations:
 * 1. Returns true only if the JSONs are exactly the same
 * 2. The keys don't have to be in the same order for the two JSON's to be equal.
 * 3. Array elements don't have to be in same order for the JSON's to be equal.
 *
 */
public class JSONCompare {

    /**
     * Compares the equality with given 2 json string of type either JSONObject or JSONArray
     * Considerations:
     * 1. Returns true only if the JSONs are exactly the same
     * 2. The keys don't have to be in the same order for the two JSON's to be equal.
     * 3. Array elements don't have to be in same order for the JSON's to be equal.
     *
     * @param json1
     * @param json2
     * @return boolean
     * @throws JSONException
     */
    public static boolean equals(final String json1, final String json2) throws JSONException {
        if (json1 == null && json2 == null) {
            return true;
        } else if (json1 == null || json2 == null) {
            return false;
        }

        Object json1Obj = new JSONTokener(json1).nextValue();
        Object json2Obj = new JSONTokener(json2).nextValue();
        if (json1Obj instanceof JSONObject && json2Obj instanceof JSONObject)
            return jsonObjectEquals((JSONObject)json1Obj, (JSONObject)json2Obj);
        else if (json1Obj instanceof JSONArray && json2Obj instanceof JSONArray)
            return jsonArrayEquals((JSONArray) json1Obj, (JSONArray)json2Obj);
        else
            return false;
    }

    /**
     * Compares the equality with given 2 JSONObjects
     * Considerations:
     * 1. Returns true only if the JSONObjects are exactly the same
     * 2. The keys don't have to be in the same order for the two JSONObject's to be equal.
     * 3. Array elements don't have to be in same order for the JSONObject's to be equal.
     *
     * @param json1
     * @param json2
     * @return boolean
     */
    public static boolean jsonObjectEquals(final JSONObject json1, final JSONObject json2) {
        if (json1 == null && json2 == null) {
            return true;
        } else if (json1 == null || json2 == null) {
            return false;
        }

        boolean areEqualJson1AndJson2 = compareJsonObjects(json1, json2);
        boolean areEqualJson2AndJson1 = compareJsonObjects(json2, json1);

        return areEqualJson1AndJson2 && areEqualJson2AndJson1;
    }

    /**
     * Compares the equality with given 2 JSONArray
     * Considerations:
     * 1. Returns true only if the JSONArray are exactly same.
     * 2. Array elements don't have to be in same order and same length.
     *
     * @param array1
     * @param array2
     * @return
     */
    public static boolean jsonArrayEquals(final JSONArray array1, final JSONArray array2) {
        if(array1 == null && array2 == null) {
            return true;
        } else if(array1 == null || array2 == null) {
            return false;
        }

        if(array1.length() != array2.length()) {
            return false;
        }
        JSONArray array1Sorted = sortJsonArray(array1);
        JSONArray array2Sorted = sortJsonArray(array2);
        int arrLength = array1Sorted.length();

        for(int i = 0; i < arrLength; i++) {
            Object value1 = array1Sorted.get(i);
            Object value2 = array2Sorted.get(i);

            if(value1 instanceof JSONObject) {
                if(!(value2 instanceof JSONObject)) {
                    return false;
                } else if (!jsonObjectEquals((JSONObject) value1, (JSONObject) value2)) {
                    return false;
                }
            } else if(value1 instanceof JSONArray) {
                if(!(value2 instanceof JSONArray)) {
                    return false;
                } else if(!jsonArrayEquals((JSONArray) value1, (JSONArray) value2)) {
                    return false;
                }
            } else if (!value1.equals(value2)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Compares the equality with given 2 JSONObjects with an option to ignore certain fields while comparison
     * Considerations:
     * 1. Returns true only if the JSONObjects are exactly the same after ignoring the List<String> ignoreJsonObjectKeys
     * 2. ignoreJsonObjectKeys will be ignored recursively
     * 3. The keys don't have to be in the same order for the two JSONObject's to be equal.
     * 4. Array elements don't have to be in same order for the JSONObject's to be equal.
     * 5. ignoreJsonObjectKeys will also be applicable on nested JSONObject's within JSONArray elements
     *
     * @param json1
     * @param json2
     * @return boolean
     */
    public static boolean jsonObjectEquals(final JSONObject json1, final JSONObject json2, final List<String> ignoreJsonObjectKeys) {
        if(json1 == null && json2 == null) {
            return true;
        } else if(json1 == null || json2 == null) {
            return false;
        }

        if (!CollectionUtils.isEmpty(ignoreJsonObjectKeys)) {
            ignoreJsonObjectKeys.forEach(propKey -> {
                if (json1.has(propKey)) json1.remove(propKey);
                if (json2.has(propKey)) json2.remove(propKey);
            });

        }

        boolean areEqualJson1AndJson2 = compareJsonObjects(json1, json2, ignoreJsonObjectKeys);
        boolean areEqualJson2AndJson1 = compareJsonObjects(json2, json1, ignoreJsonObjectKeys);

        return areEqualJson1AndJson2 && areEqualJson2AndJson1;
    }

    /**
     * Compares the equality with given 2 JSONArray with an option to ignore certain fields on JSONObjects within JSONArray elements
     * Considerations:
     * 1. Returns true only if the JSONArray are exactly same.
     * 2. Array elements don't have to be in same order and same length.
     * 3. ignoreJsonObjectKeys will also be applicable on nested JSONObject's within JSONArray elements
     *
     * @param array1
     * @param array2
     * @return
     */
    public static boolean jsonArrayEquals(final JSONArray array1, final JSONArray array2, final List<String> ignoreJsonObjectKeys) {
        if(array1 == null && array2 == null) {
            return true;
        } else if(array1 == null || array1 == null) {
            return false;
        }

        if(array1.length() != array2.length()) {
            return false;
        }

        JSONArray array1Sorted = sortJsonArray(array1);
        JSONArray array2Sorted = sortJsonArray(array2);
        int arrLength = array1Sorted.length();

        for(int i = 0; i < arrLength; i++) {
            Object value1 = array1Sorted.get(i);
            Object value2 = array2Sorted.get(i);

            if(value1 instanceof JSONObject) {
                if(!(value2 instanceof JSONObject)) {
                    return false;
                } else if (!jsonObjectEquals((JSONObject) value1, (JSONObject) value2, ignoreJsonObjectKeys)) {
                    return false;
                }
            } else if(value1 instanceof JSONArray) {
                if(!(value2 instanceof JSONArray)) {
                    return false;
                } else if(!jsonArrayEquals((JSONArray) value1, (JSONArray) value2, ignoreJsonObjectKeys)) {
                    return false;
                }
            } else if (!value1.equals(value2)) {
                return false;
            }
        }

        return true;
    }

    private static boolean compareJsonObjects(final JSONObject json1, final JSONObject json2) {
        for (String key : json1.keySet()) {
            if (!json2.has(key)) {
                return false;
            }

            Object json1Value = json1.get(key);
            Object json2Value = json2.get(key);

            if(json1Value instanceof JSONObject) {
                if(!(json2Value instanceof JSONObject)) {
                    return false;
                } else if (!jsonObjectEquals((JSONObject) json1Value, (JSONObject) json2Value)) {
                    return false;
                }
            } else if(json1Value instanceof JSONArray) {
                if(!(json2Value instanceof JSONArray)) {
                    return false;
                } else if(!jsonArrayEquals((JSONArray) json1Value, (JSONArray) json2Value)) {
                    return false;
                }
            } else if(!json2.get(key).equals(json1.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareJsonObjects(final JSONObject json1, final JSONObject json2, final List<String> ignoreJsonObjectKeys) {
        for(String key : json1.keySet()) {
            if(!json2.has(key)) {
                return false;
            }

            Object json1Value = json1.get(key);
            Object json2Value = json2.get(key);

            if(json1Value instanceof JSONObject) {
                if(!(json2Value instanceof JSONObject)) {
                    return false;
                } else if (!jsonObjectEquals((JSONObject) json1Value, (JSONObject) json2Value, ignoreJsonObjectKeys)) {
                    return false;
                }
            } else if(json1Value instanceof JSONArray) {
                if(!(json2Value instanceof JSONArray)) {
                    return false;
                } else if(!jsonArrayEquals((JSONArray) json1Value, (JSONArray) json2Value, ignoreJsonObjectKeys)) {
                    return false;
                }
            } else if(!json2.get(key).equals(json1.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static JSONArray sortJsonArray(JSONArray jsonArray) {
        JSONArray sortedJsonArray = new JSONArray();
        Object[] list = new Object[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            list[i] = jsonArray.get(i);
        }
        Arrays.sort(list);
        return new JSONArray(list);

    }

}
