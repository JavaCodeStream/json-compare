package edu.sandip.javacodestream.json;

import com.google.common.collect.Lists;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class JSONCompareTest {

    @Test
    public void bothJsonAreExpectedToBeEqual_simple_json_array() {
        String json1 = "[\"Java\", \"C++\", \"Python\"]";
        String json2 = "[\"Java\", \"C++\", \"Python\"] ";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_simple_json_array1() {
        String json1 = "[\"Java\", \"C++\", \"Python\"]";
        String json2 = "[\"Java\", \"Python\", \"C++\"] ";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_simple_json_array() {
        String json1 = "[\"Java\", \"C++\", \"Python\"]";
        String json2 = "[\"Java\", \"C++\"] ";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_complex_json_array() {
        String json1 = "[\n" +
                "  {\n" +
                "    \"label\": \"commodity\",\n" +
                "    \"displayName\": \"Commodity\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"label\": \"country\",\n" +
                "    \"displayName\": \"Country\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"label\": \"wiki\",\n" +
                "    \"displayName\": \"Wiki\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"label\": \"custom\",\n" +
                "    \"displayName\": \"Custom\"\n" +
                "  }\n" +
                "]";
        String json2 = "[\n" +
                "  {\n" +
                "    \"label\": \"commodity\",\n" +
                "    \"displayName\": \"Commodity\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"label\": \"country\",\n" +
                "    \"displayName\": \"Country\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"label\": \"wiki\",\n" +
                "    \"displayName\": \"Wiki\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"label\": \"custom\",\n" +
                "    \"displayName\": \"Custom\"\n" +
                "  }\n" +
                "]";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_simple_json_array_object() {
        String json1 = "[\"Java\", \"C++\", \"Python\"]";
        String json2 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"age\": 34\n" +
                "    }\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_simple_json() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\"\n" +
                "}";
        String json2 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"US\"\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_simple_json() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\"\n" +
                "}";
        String json2 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\"\n" +
                "}";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_nested_json() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\"\n" +
                "  }\n" +
                "}";
        String json2 = "{" +
                "name : Tom, " +
                "country : USA, " +
                "address : { " +
                                "line1 : 'Lane 1, USA'" +
                         " }" +
                "}";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_nested_json() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"My lane\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\"\n" +
                "  }\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_nested_json2() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"My lane\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_nested_json3() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"age\": \"32\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "  }\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_nested_json4() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_array_json1() {
        String json1 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"age\": 34,\n" +
                "        \"skills\": [\"Java\", \"C++\", \"Python\"]\n" +
                "    }\n" +
                "}";
        String json2 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"age\": 34,\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"skills\": [\"Java\", \"C++\", \"Python\"] \n" +
                "    } \n" +
                "}";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_array_diffOrder() {
        String json1 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"age\": 34,\n" +
                "        \"skills\": [\"C++\", \"Java\", \"Python\"]\n" +
                "    }\n" +
                "}";
        String json2 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"age\": 34,\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"skills\": [\"Java\", \"C++\", \"Python\"] \n" +
                "    } \n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_array_lessNumberOfElement() {
        String json1 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"age\": 34,\n" +
                "        \"skills\": [\"C++\", \"Python\"]\n" +
                "    }\n" +
                "}";
        String json2 = "{\n" +
                "    \"employee\":\n" +
                "    {\n" +
                "        \"id\": \"1212\",\n" +
                "        \"age\": 34,\n" +
                "        \"fullName\": \"John Miles\",\n" +
                "        \"skills\": [\"Java\", \"C++\", \"Python\"] \n" +
                "    } \n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_complex_json1() {
        String json1 = "{\n" +
                "  \"uri\": \"http://gs.com/lex/corporate/npc_restaurant_holdings_llc\",\n" +
                "  \"name\": \"NPC Restaurant Holdings LLC\",\n" +
                "  \"entityType\": \"corporate\",\n" +
                "  \"identifiers\": {},\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_natural_id\": \"15993965\",\n" +
                "    \"p_natural_id_type\": \"BBG\",\n" +
                "    \"p_isDeprecated\": \"false\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"NPC Management Inc\",\n" +
                "    \"NPC International Inc / NPC Quality Burgers Inc / NPC Operating Co B Inc\",\n" +
                "    \"NPC International Inc\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_bbg\": \"0844e05cd8d54018801a869559067aab\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"uri\": \"http://gs.com/lex/corporate/npc_restaurant_holdings_llc\",\n" +
                "  \"name\": \"NPC Restaurant Holdings LLC\",\n" +
                "  \"entityType\": \"corporate\",\n" +
                "  \"identifiers\": {},\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_natural_id\": \"15993965\",\n" +
                "    \"p_natural_id_type\": \"BBG\",\n" +
                "    \"p_isDeprecated\": \"false\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"NPC Management Inc\",\n" +
                "    \"NPC International Inc / NPC Quality Burgers Inc / NPC Operating Co B Inc\",\n" +
                "    \"NPC International Inc\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_bbg\": \"0844e05cd8d54018801a869559067aab\"\n" +
                "  }\n" +
                "}";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedToBeEqual_complex_json2() {
        String json1 = "{\n" +
                "  \"uri\": \"http://gs.com/lex/emmacorporate/1533525_safeway_inc\",\n" +
                "  \"name\": \"SAFEWAY INC.\",\n" +
                "  \"entityType\": \"emmacorporate\",\n" +
                "  \"identifiers\": {\n" +
                "    \"i_bond_ticker\": [\n" +
                "      \"ACI\",\n" +
                "      \"SWY\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"013092AA9\",\n" +
                "      \"013092AB7\",\n" +
                "      \"013092AC5\",\n" +
                "      \"013093AB5\",\n" +
                "      \"013093AD1\",\n" +
                "      \"786514BA6\",\n" +
                "      \"U0125LAB6\"\n" +
                "    ],\n" +
                "    \"i_prime_id\": [\n" +
                "      \"27050735\",\n" +
                "      \"366757123\",\n" +
                "      \"366757124\",\n" +
                "      \"366868497\",\n" +
                "      \"366905022\",\n" +
                "      \"366905023\",\n" +
                "      \"366926032\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"US013092AA91\",\n" +
                "      \"US013092AB74\",\n" +
                "      \"US013092AC57\",\n" +
                "      \"US013093AB57\",\n" +
                "      \"US013093AD14\",\n" +
                "      \"US786514BA67\",\n" +
                "      \"USU0125LAB63\"\n" +
                "    ],\n" +
                "    \"i_fish_product_key\": [\n" +
                "      \"2028100\",\n" +
                "      \"2028105\",\n" +
                "      \"2423519\",\n" +
                "      \"2623137\",\n" +
                "      \"2623141\",\n" +
                "      \"2701424\",\n" +
                "      \"7844\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_bbg_id\": \"65936134\",\n" +
                "    \"p_desk_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isMloParent\": \"false\",\n" +
                "    \"p_natural_id\": \"1533525\",\n" +
                "    \"p_natural_id_type\": \"EMMA\",\n" +
                "    \"p_issuer_source\": [\n" +
                "      \"BENCHMARK\",\n" +
                "      \"HELD\"\n" +
                "    ],\n" +
                "    \"p_perspective\": [\n" +
                "      \"p_perspective_bbg_parent\",\n" +
                "      \"p_perspective_emma_parent\"\n" +
                "    ],\n" +
                "    \"p_perspective_bbg_parent\": [\n" +
                "      \"http://gs.com/lex/corporate/65936134_albertsons_cos_inc__safeway_inc__new_albertsons_lp__albertsons_llc\"\n" +
                "    ],\n" +
                "    \"p_desk_parent_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isDeprecated\": \"false\",\n" +
                "    \"p_perspective_emma_parent\": \"http://gs.com/lex/emmacorporate/21978453_albertsons_investor_holdings_llc\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"SAFEWAY INC.\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_emma\": \"85933fb00ff6c9bef1335d27326a00e4\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"uri\": \"http://gs.com/lex/emmacorporate/1533525_safeway_inc\",\n" +
                "  \"name\": \"SAFEWAY INC.\",\n" +
                "  \"entityType\": \"emmacorporate\",\n" +
                "  \"identifiers\": {\n" +
                "    \"i_bond_ticker\": [\n" +
                "      \"ACI\",\n" +
                "      \"SWY\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"013092AA9\",\n" +
                "      \"013092AB7\",\n" +
                "      \"013092AC5\",\n" +
                "      \"013093AB5\",\n" +
                "      \"013093AD1\",\n" +
                "      \"786514BA6\",\n" +
                "      \"U0125LAB6\"\n" +
                "    ],\n" +
                "    \"i_prime_id\": [\n" +
                "      \"27050735\",\n" +
                "      \"366757123\",\n" +
                "      \"366757124\",\n" +
                "      \"366868497\",\n" +
                "      \"366905022\",\n" +
                "      \"366905023\",\n" +
                "      \"366926032\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"US013092AA91\",\n" +
                "      \"US013092AB74\",\n" +
                "      \"US013092AC57\",\n" +
                "      \"US013093AB57\",\n" +
                "      \"US013093AD14\",\n" +
                "      \"US786514BA67\",\n" +
                "      \"USU0125LAB63\"\n" +
                "    ],\n" +
                "    \"i_fish_product_key\": [\n" +
                "      \"2028100\",\n" +
                "      \"2028105\",\n" +
                "      \"2423519\",\n" +
                "      \"2623137\",\n" +
                "      \"2623141\",\n" +
                "      \"2701424\",\n" +
                "      \"7844\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_bbg_id\": \"65936134\",\n" +
                "    \"p_desk_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isMloParent\": \"false\",\n" +
                "    \"p_natural_id\": \"1533525\",\n" +
                "    \"p_natural_id_type\": \"EMMA\",\n" +
                "    \"p_issuer_source\": [\n" +
                "      \"BENCHMARK\",\n" +
                "      \"HELD\"\n" +
                "    ],\n" +
                "    \"p_perspective\": [\n" +
                "      \"p_perspective_bbg_parent\",\n" +
                "      \"p_perspective_emma_parent\"\n" +
                "    ],\n" +
                "    \"p_perspective_bbg_parent\": [\n" +
                "      \"http://gs.com/lex/corporate/65936134_albertsons_cos_inc__safeway_inc__new_albertsons_lp__albertsons_llc\"\n" +
                "    ],\n" +
                "    \"p_desk_parent_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isDeprecated\": \"false\",\n" +
                "    \"p_perspective_emma_parent\": \"http://gs.com/lex/emmacorporate/21978453_albertsons_investor_holdings_llc\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"SAFEWAY INC.\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_emma\": \"85933fb00ff6c9bef1335d27326a00e4\"\n" +
                "  }\n" +
                "}";
        Assert.assertTrue(JSONCompare.equals(json1, json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqual_complex_json2_array_order() {
        String json1 = "{\n" +
                "  \"uri\": \"http://gs.com/lex/emmacorporate/1533525_safeway_inc\",\n" +
                "  \"name\": \"SAFEWAY INC.\",\n" +
                "  \"entityType\": \"emmacorporate\",\n" +
                "  \"identifiers\": {\n" +
                "    \"i_bond_ticker\": [\n" +
                "      \"ACI\",\n" +
                "      \"SWY\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"013092AA9\",\n" +
                "      \"013092AB7\",\n" +
                "      \"013092AC5\",\n" +
                "      \"013093AB5\",\n" +
                "      \"013093AD1\",\n" +
                "      \"786514BA6\",\n" +
                "      \"U0125LAB6\"\n" +
                "    ],\n" +
                "    \"i_prime_id\": [\n" +
                "      \"27050735\",\n" +
                "      \"366757123\",\n" +
                "      \"366757124\",\n" +
                "      \"366868497\",\n" +
                "      \"366905022\",\n" +
                "      \"366905023\",\n" +
                "      \"366926032\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"US013092AA91\",\n" +
                "      \"US013092AB74\",\n" +
                "      \"US013092AC57\",\n" +
                "      \"US013093AB57\",\n" +
                "      \"US013093AD14\",\n" +
                "      \"US786514BA67\",\n" +
                "      \"USU0125LAB63\"\n" +
                "    ],\n" +
                "    \"i_fish_product_key\": [\n" +
                "      \"2028100\",\n" +
                "      \"2028105\",\n" +
                "      \"2423519\",\n" +
                "      \"2623137\",\n" +
                "      \"2623141\",\n" +
                "      \"2701424\",\n" +
                "      \"7844\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_bbg_id\": \"65936134\",\n" +
                "    \"p_desk_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isMloParent\": \"false\",\n" +
                "    \"p_natural_id\": \"1533525\",\n" +
                "    \"p_natural_id_type\": \"EMMA\",\n" +
                "    \"p_issuer_source\": [\n" +
                "      \"BENCHMARK\",\n" +
                "      \"HELD\"\n" +
                "    ],\n" +
                "    \"p_perspective\": [\n" +
                "      \"p_perspective_bbg_parent\",\n" +
                "      \"p_perspective_emma_parent\"\n" +
                "    ],\n" +
                "    \"p_perspective_bbg_parent\": [\n" +
                "      \"http://gs.com/lex/corporate/65936134_albertsons_cos_inc__safeway_inc__new_albertsons_lp__albertsons_llc\"\n" +
                "    ],\n" +
                "    \"p_desk_parent_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isDeprecated\": \"false\",\n" +
                "    \"p_perspective_emma_parent\": \"http://gs.com/lex/emmacorporate/21978453_albertsons_investor_holdings_llc\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"SAFEWAY INC.\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_emma\": \"85933fb00ff6c9bef1335d27326a00e4\"\n" +
                "  }\n" +
                "}";
        String json2 = "{\n" +
                "  \"uri\": \"http://gs.com/lex/emmacorporate/1533525_safeway_inc\",\n" +
                "  \"name\": \"SAFEWAY INC.\",\n" +
                "  \"entityType\": \"emmacorporate\",\n" +
                "  \"identifiers\": {\n" +
                "    \"i_bond_ticker\": [\n" +
                "      \"ACI\",\n" +
                "      \"SWY\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"013092AB7\",\n" +
                "      \"013092AA9\",\n" +
                "      \"013092AC5\",\n" +
                "      \"013093AB5\",\n" +
                "      \"013093AD1\",\n" +
                "      \"786514BA6\",\n" +
                "      \"U0125LAB6\"\n" +
                "    ],\n" +
                "    \"i_prime_id\": [\n" +
                "      \"27050735\",\n" +
                "      \"366757123\",\n" +
                "      \"366757124\",\n" +
                "      \"366868497\",\n" +
                "      \"366905022\",\n" +
                "      \"366905023\",\n" +
                "      \"366926032\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"US013092AA91\",\n" +
                "      \"US013092AB74\",\n" +
                "      \"US013092AC57\",\n" +
                "      \"US013093AB57\",\n" +
                "      \"US013093AD14\",\n" +
                "      \"US786514BA67\",\n" +
                "      \"USU0125LAB63\"\n" +
                "    ],\n" +
                "    \"i_fish_product_key\": [\n" +
                "      \"2028100\",\n" +
                "      \"2028105\",\n" +
                "      \"2423519\",\n" +
                "      \"2623137\",\n" +
                "      \"2623141\",\n" +
                "      \"2701424\",\n" +
                "      \"7844\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_bbg_id\": \"65936134\",\n" +
                "    \"p_desk_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isMloParent\": \"false\",\n" +
                "    \"p_natural_id\": \"1533525\",\n" +
                "    \"p_natural_id_type\": \"EMMA\",\n" +
                "    \"p_issuer_source\": [\n" +
                "      \"BENCHMARK\",\n" +
                "      \"HELD\"\n" +
                "    ],\n" +
                "    \"p_perspective\": [\n" +
                "      \"p_perspective_bbg_parent\",\n" +
                "      \"p_perspective_emma_parent\"\n" +
                "    ],\n" +
                "    \"p_perspective_bbg_parent\": [\n" +
                "      \"http://gs.com/lex/corporate/65936134_albertsons_cos_inc__safeway_inc__new_albertsons_lp__albertsons_llc\"\n" +
                "    ],\n" +
                "    \"p_desk_parent_issuer_name\": [\n" +
                "      \"ALBERTSONS\",\n" +
                "      \"SAFEWAY INC\"\n" +
                "    ],\n" +
                "    \"p_isDeprecated\": \"false\",\n" +
                "    \"p_perspective_emma_parent\": \"http://gs.com/lex/emmacorporate/21978453_albertsons_investor_holdings_llc\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"SAFEWAY INC.\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_emma\": \"85933fb00ff6c9bef1335d27326a00e4\"\n" +
                "  }\n" +
                "}";
        Assert.assertFalse(JSONCompare.equals(json1, json2));
    }

    @Test
    public void testRemoveJSONObject() {
        String json1 = "{\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"name\": \"Tom\",\n" +
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";
        JSONObject jsonObj = new JSONObject(json1);
        jsonObj.remove("name");
        jsonObj.remove("country");

        String json2 = "{\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"name\": \"Tom\",\n" +
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";

        Assert.assertTrue(JSONCompare.equals(jsonObj.toString(), json2));
    }

    @Test
    public void bothJsonAreExpectedNotToBeEqualWithIgnoredKeys_use_case_1() {
        String json1 = "{\n" +
                "  \"socialSecurityId\": \"1119867\",\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"socialSecurityId\": \"785667\",\n" + // diff key
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";

        String json2 = "{\n" +
                "  \"socialSecurityId\": \"1119867\",\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"socialSecurityId1\": \"785667\",\n" + // diff key
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";

        Assert.assertFalse(JSONCompare.jsonObjectEquals(new JSONObject(json1), new JSONObject(json2), Lists.newArrayList("socialSecurityId", "line1")));
    }

    @Test
    public void bothJsonAreExpectedToBeEqualWithIgnoredKeys_use_case_1() {
        String json1 = "{\n" +
                "  \"socialSecurityId\": \"2222222\",\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"socialSecurityId\": \"9999999\",\n" + // diff value
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";

        String json2 = "{\n" +
                "  \"socialSecurityId\": \"2222222\",\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"socialSecurityId\": \"1111111\",\n" +  // diff value
                "    \"zip\": \"19700\"\n" +
                "  }\n" +
                "}";

        Assert.assertTrue(JSONCompare.jsonObjectEquals(new JSONObject(json1), new JSONObject(json2), Lists.newArrayList("socialSecurityId", "line1")));
    }


    @Test
    public void bothJsonAreExpectedToBeEqualWithIgnoredKeys_use_case_2() {
        String json1 = "{\n" +
                "  \"socialSecurityId\": \"2222222\",\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"socialSecurityId\": \"9999999\",\n" + // diff value
                "    \"zip\": \"19700\"\n" +
                "  },\n" +
                "  \"relationships\": [\n" +
                "    {\n" +
                "      \"socialSecurityId\": \"9999999\",\n" + // diff value
                "       \"label\": \"belongsTo\",\n" +
                "       \"line1\": \"Lane 1, USA\",\n" +
                "       \"md5HashValues\": {\n" +
                "           \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "    }\n" +
                "  ],\n" +
                "}";

        String json2 = "{\n" +
                "  \"socialSecurityId\": \"2222222\",\n" +
                "  \"name\": \"Tom\",\n" +
                "  \"country\": \"USA\",\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"Lane 1, USA\",\n" +
                "    \"socialSecurityId\": \"1111111\",\n" +  // diff value
                "    \"zip\": \"19700\"\n" +
                "  },\n" +
                "  \"relationships\": [\n" +
                "    {\n" +
                "      \"socialSecurityId\": \"1111111\",\n" + // diff value
                "       \"label\": \"belongsTo\",\n" +
                "       \"line1\": \"Lane 1, USA\",\n" +
                "       \"md5HashValues\": {\n" +
                "           \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "    }\n" +
                "  ],\n" +
                "}";

        Assert.assertTrue(JSONCompare.jsonObjectEquals(new JSONObject(json1), new JSONObject(json2), Lists.newArrayList("socialSecurityId", "line1")));
    }

    @Test
    public void bothJsonAreExpectedToBeEqualWithIgnoredKeys_complex_use_case_1() {
        String json1 = "{\n" +
                "  \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "  \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "  \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "  \"entityType\": \"corporate\",\n" +
                "  \"relationships\": [\n" +
                "    {\n" +
                "      \"id\": \"fbb4d733-b10a-3980-8dcf-210b91783e16\",\n" +
                "      \"label\": \"belongsTo\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"af50bf7e-37ba-36fb-a59a-defee9f11ca8\",\n" +
                "        \"uri\": \"http://gs.com/lex/industry/test1_industry_health_care_1577716308045\",\n" +
                "        \"name\": \"Test1 Industry Health Care\",\n" +
                "        \"entityType\": \"industry\",\n" +
                "        \"identifiers\": {},\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {},\n" +
                "        \"synonyms\": [],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 2,\n" +
                "        \"md5HashValues\": {}\n" +
                "      },\n" +
                "      \"usedForSearch\": true,\n" +
                "      \"tobeUsedForTagging\": true,\n" +
                "      \"pointingToParent\": true,\n" +
                "      \"version\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"13e8cce5-bccf-372a-a793-17fa761a77e2\",\n" +
                "      \"label\": \"domiciledIn\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"5aafd393-a675-3827-ba86-994e766daacd\",\n" +
                "        \"uri\": \"http://gs.com/lex/country/test1_country_1577716308045\",\n" +
                "        \"name\": \"Test1 Country\",\n" +
                "        \"entityType\": \"country\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_wikidata_link\": [\n" +
                "            \"http://en.wikipedia.org/wiki/test1China\"\n" +
                "          ],\n" +
                "          \"i_dbpedia_uri\": [\n" +
                "            \"Test1China\"\n" +
                "          ],\n" +
                "          \"i_bond_ticker\": [\n" +
                "            \"TEST1CGB\",\n" +
                "            \"TEST1CHINA\",\n" +
                "            \"TEST1CHMERC\",\n" +
                "            \"TEST1HUIJIN\"\n" +
                "          ],\n" +
                "          \"i_wikidata_id\": [\n" +
                "            \"TEST1Q148\"\n" +
                "          ],\n" +
                "          \"i_2_letter_country_iso_code\": \"TEST1CN\"\n" +
                "        },\n" +
                "        \"attributes\": {\n" +
                "          \"a_capital\": \"TEST1Beijing\"\n" +
                "        },\n" +
                "        \"properties\": {\n" +
                "          \"p_perspective_parent\": [\n" +
                "            \"http://gs.com/lex/wiki/test1_wiki_q148_1577716308045\"\n" +
                "          ],\n" +
                "          \"p_natural_id\": \"TEST1CN\",\n" +
                "          \"p_natural_id_type\": \"GSAM-DATA\",\n" +
                "          \"p_perspective\": [\n" +
                "            \"p_perspective_parent\"\n" +
                "          ],\n" +
                "          \"p_isDeprecated\": \"true\",\n" +
                "          \"p_isCovered\": \"false\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1CCina\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_gsam_data\": \"testd59e223dacad94b514afe62cd673a5c2\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"usedForSearch\": false,\n" +
                "      \"tobeUsedForTagging\": false,\n" +
                "      \"pointingToParent\": false,\n" +
                "      \"version\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4e30380a-2257-324b-8082-0639493b71d2\",\n" +
                "      \"label\": \"hasCompany\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"5aafd393-a675-3827-ba86-994e766daacd\",\n" +
                "        \"uri\": \"http://gs.com/lex/country/test1_country_1577716308045\",\n" +
                "        \"name\": \"Test1 Country\",\n" +
                "        \"entityType\": \"country\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_wikidata_link\": [\n" +
                "            \"http://en.wikipedia.org/wiki/test1China\"\n" +
                "          ],\n" +
                "          \"i_dbpedia_uri\": [\n" +
                "            \"Test1China\"\n" +
                "          ],\n" +
                "          \"i_bond_ticker\": [\n" +
                "            \"TEST1CGB\",\n" +
                "            \"TEST1CHINA\",\n" +
                "            \"TEST1CHMERC\",\n" +
                "            \"TEST1HUIJIN\"\n" +
                "          ],\n" +
                "          \"i_wikidata_id\": [\n" +
                "            \"TEST1Q148\"\n" +
                "          ],\n" +
                "          \"i_2_letter_country_iso_code\": \"TEST1CN\"\n" +
                "        },\n" +
                "        \"attributes\": {\n" +
                "          \"a_capital\": \"TEST1Beijing\"\n" +
                "        },\n" +
                "        \"properties\": {\n" +
                "          \"p_perspective_parent\": [\n" +
                "            \"http://gs.com/lex/wiki/test1_wiki_q148_1577716308045\"\n" +
                "          ],\n" +
                "          \"p_natural_id\": \"TEST1CN\",\n" +
                "          \"p_natural_id_type\": \"GSAM-DATA\",\n" +
                "          \"p_perspective\": [\n" +
                "            \"p_perspective_parent\"\n" +
                "          ],\n" +
                "          \"p_isDeprecated\": \"true\",\n" +
                "          \"p_isCovered\": \"false\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1CCina\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_gsam_data\": \"testd59e223dacad94b514afe62cd673a5c2\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"usedForSearch\": false,\n" +
                "      \"tobeUsedForTagging\": false,\n" +
                "      \"pointingToParent\": false,\n" +
                "      \"version\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9717e0b8-d63e-3e01-8136-4193bbc6c268\",\n" +
                "      \"label\": \"hasCompany\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"af50bf7e-37ba-36fb-a59a-defee9f11ca8\",\n" +
                "        \"uri\": \"http://gs.com/lex/industry/test1_industry_health_care_1577716308045\",\n" +
                "        \"name\": \"Test1 Industry Health Care\",\n" +
                "        \"entityType\": \"industry\",\n" +
                "        \"identifiers\": {},\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {},\n" +
                "        \"synonyms\": [],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 2,\n" +
                "        \"md5HashValues\": {}\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"usedForSearch\": true,\n" +
                "      \"tobeUsedForTagging\": true,\n" +
                "      \"pointingToParent\": false,\n" +
                "      \"version\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"identifiers\": {\n" +
                "    \"i_ric\": [\n" +
                "      \"TEST1.ABC.PK\",\n" +
                "      \"TEST1.ABMT.PK\"\n" +
                "    ],\n" +
                "    \"i_bid\": [\n" +
                "      \"TEST1EQ0000000003798934\",\n" +
                "      \"TEST1EQ111\"\n" +
                "    ],\n" +
                "    \"i_ticker\": [\n" +
                "      \"TEST1ABMT\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"TEST100752M101\"\n" +
                "    ],\n" +
                "    \"i_sedol\": [\n" +
                "      \"TEST1B23QDM1\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"TEST1US00752M1018\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_natural_id\": \"TEST112422410\",\n" +
                "    \"p_website\": \"www.testabtlafleur.com\",\n" +
                "    \"p_natural_id_type\": \"BBG\",\n" +
                "    \"p_isDeprecated\": \"true\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"Test1 Company Name3\",\n" +
                "    \"Test1 Company Name1\",\n" +
                "    \"Test1 Company Name2\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"version\": 1,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "  }\n" +
                "}";

        String json2 = "{\n" +
                "  \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "  \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "  \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "  \"entityType\": \"corporate\",\n" +
                "  \"relationships\": [\n" +
                "    {\n" +
                "      \"id\": \"fbb4d733-b10a-3980-8dcf-210b91783e16\",\n" +
                "      \"label\": \"belongsTo\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"af50bf7e-37ba-36fb-a59a-defee9f11ca8\",\n" +
                "        \"uri\": \"http://gs.com/lex/industry/test1_industry_health_care_1577716308045\",\n" +
                "        \"name\": \"Test1 Industry Health Care\",\n" +
                "        \"entityType\": \"industry\",\n" +
                "        \"identifiers\": {},\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {},\n" +
                "        \"synonyms\": [],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {}\n" +
                "      },\n" +
                "      \"usedForSearch\": true,\n" +
                "      \"tobeUsedForTagging\": true,\n" +
                "      \"pointingToParent\": true,\n" +
                "      \"version\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"13e8cce5-bccf-372a-a793-17fa761a77e2\",\n" +
                "      \"label\": \"domiciledIn\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"5aafd393-a675-3827-ba86-994e766daacd\",\n" +
                "        \"uri\": \"http://gs.com/lex/country/test1_country_1577716308045\",\n" +
                "        \"name\": \"Test1 Country\",\n" +
                "        \"entityType\": \"country\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_wikidata_link\": [\n" +
                "            \"http://en.wikipedia.org/wiki/test1China\"\n" +
                "          ],\n" +
                "          \"i_dbpedia_uri\": [\n" +
                "            \"Test1China\"\n" +
                "          ],\n" +
                "          \"i_bond_ticker\": [\n" +
                "            \"TEST1CGB\",\n" +
                "            \"TEST1CHINA\",\n" +
                "            \"TEST1CHMERC\",\n" +
                "            \"TEST1HUIJIN\"\n" +
                "          ],\n" +
                "          \"i_wikidata_id\": [\n" +
                "            \"TEST1Q148\"\n" +
                "          ],\n" +
                "          \"i_2_letter_country_iso_code\": \"TEST1CN\"\n" +
                "        },\n" +
                "        \"attributes\": {\n" +
                "          \"a_capital\": \"TEST1Beijing\"\n" +
                "        },\n" +
                "        \"properties\": {\n" +
                "          \"p_perspective_parent\": [\n" +
                "            \"http://gs.com/lex/wiki/test1_wiki_q148_1577716308045\"\n" +
                "          ],\n" +
                "          \"p_natural_id\": \"TEST1CN\",\n" +
                "          \"p_natural_id_type\": \"GSAM-DATA\",\n" +
                "          \"p_perspective\": [\n" +
                "            \"p_perspective_parent\"\n" +
                "          ],\n" +
                "          \"p_isDeprecated\": \"true\",\n" +
                "          \"p_isCovered\": \"false\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1CCina\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_gsam_data\": \"testd59e223dacad94b514afe62cd673a5c2\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"usedForSearch\": false,\n" +
                "      \"tobeUsedForTagging\": false,\n" +
                "      \"pointingToParent\": false,\n" +
                "      \"version\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4e30380a-2257-324b-8082-0639493b71d2\",\n" +
                "      \"label\": \"hasCompany\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"5aafd393-a675-3827-ba86-994e766daacd\",\n" +
                "        \"uri\": \"http://gs.com/lex/country/test1_country_1577716308045\",\n" +
                "        \"name\": \"Test1 Country\",\n" +
                "        \"entityType\": \"country\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_wikidata_link\": [\n" +
                "            \"http://en.wikipedia.org/wiki/test1China\"\n" +
                "          ],\n" +
                "          \"i_dbpedia_uri\": [\n" +
                "            \"Test1China\"\n" +
                "          ],\n" +
                "          \"i_bond_ticker\": [\n" +
                "            \"TEST1CGB\",\n" +
                "            \"TEST1CHINA\",\n" +
                "            \"TEST1CHMERC\",\n" +
                "            \"TEST1HUIJIN\"\n" +
                "          ],\n" +
                "          \"i_wikidata_id\": [\n" +
                "            \"TEST1Q148\"\n" +
                "          ],\n" +
                "          \"i_2_letter_country_iso_code\": \"TEST1CN\"\n" +
                "        },\n" +
                "        \"attributes\": {\n" +
                "          \"a_capital\": \"TEST1Beijing\"\n" +
                "        },\n" +
                "        \"properties\": {\n" +
                "          \"p_perspective_parent\": [\n" +
                "            \"http://gs.com/lex/wiki/test1_wiki_q148_1577716308045\"\n" +
                "          ],\n" +
                "          \"p_natural_id\": \"TEST1CN\",\n" +
                "          \"p_natural_id_type\": \"GSAM-DATA\",\n" +
                "          \"p_perspective\": [\n" +
                "            \"p_perspective_parent\"\n" +
                "          ],\n" +
                "          \"p_isDeprecated\": \"true\",\n" +
                "          \"p_isCovered\": \"false\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1CCina\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_gsam_data\": \"testd59e223dacad94b514afe62cd673a5c2\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"usedForSearch\": false,\n" +
                "      \"tobeUsedForTagging\": false,\n" +
                "      \"pointingToParent\": false,\n" +
                "      \"version\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9717e0b8-d63e-3e01-8136-4193bbc6c268\",\n" +
                "      \"label\": \"hasCompany\",\n" +
                "      \"properties\": {},\n" +
                "      \"fromNode\": {\n" +
                "        \"id\": \"af50bf7e-37ba-36fb-a59a-defee9f11ca8\",\n" +
                "        \"uri\": \"http://gs.com/lex/industry/test1_industry_health_care_1577716308045\",\n" +
                "        \"name\": \"Test1 Industry Health Care\",\n" +
                "        \"entityType\": \"industry\",\n" +
                "        \"identifiers\": {},\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {},\n" +
                "        \"synonyms\": [],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {}\n" +
                "      },\n" +
                "      \"toNode\": {\n" +
                "        \"id\": \"161239aa-c685-3459-b9a3-0b59aa5c0284\",\n" +
                "        \"uri\": \"http://gs.com/lex/corporate/test1_company_advanced_biomedical_1577716308045\",\n" +
                "        \"name\": \"TEST1 Company Advanced BioMedical\",\n" +
                "        \"entityType\": \"corporate\",\n" +
                "        \"identifiers\": {\n" +
                "          \"i_ric\": [\n" +
                "            \"TEST1.ABC.PK\",\n" +
                "            \"TEST1.ABMT.PK\"\n" +
                "          ],\n" +
                "          \"i_bid\": [\n" +
                "            \"TEST1EQ0000000003798934\",\n" +
                "            \"TEST1EQ111\"\n" +
                "          ],\n" +
                "          \"i_ticker\": [\n" +
                "            \"TEST1ABMT\"\n" +
                "          ],\n" +
                "          \"i_cusip\": [\n" +
                "            \"TEST100752M101\"\n" +
                "          ],\n" +
                "          \"i_sedol\": [\n" +
                "            \"TEST1B23QDM1\"\n" +
                "          ],\n" +
                "          \"i_isin\": [\n" +
                "            \"TEST1US00752M1018\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"attributes\": {},\n" +
                "        \"properties\": {\n" +
                "          \"p_natural_id\": \"TEST112422410\",\n" +
                "          \"p_website\": \"www.testabtlafleur.com\",\n" +
                "          \"p_natural_id_type\": \"BBG\",\n" +
                "          \"p_isDeprecated\": \"true\"\n" +
                "        },\n" +
                "        \"synonyms\": [\n" +
                "          \"Test1 Company Name3\",\n" +
                "          \"Test1 Company Name1\",\n" +
                "          \"Test1 Company Name2\"\n" +
                "        ],\n" +
                "        \"softDeleted\": false,\n" +
                "        \"usedForSearch\": true,\n" +
                "        \"version\": 1,\n" +
                "        \"md5HashValues\": {\n" +
                "          \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"usedForSearch\": true,\n" +
                "      \"tobeUsedForTagging\": true,\n" +
                "      \"pointingToParent\": false,\n" +
                "      \"version\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"identifiers\": {\n" +
                "    \"i_ric\": [\n" +
                "      \"TEST1.ABC.PK\",\n" +
                "      \"TEST1.ABMT.PK\"\n" +
                "    ],\n" +
                "    \"i_bid\": [\n" +
                "      \"TEST1EQ0000000003798934\",\n" +
                "      \"TEST1EQ111\"\n" +
                "    ],\n" +
                "    \"i_ticker\": [\n" +
                "      \"TEST1ABMT\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"TEST100752M101\"\n" +
                "    ],\n" +
                "    \"i_sedol\": [\n" +
                "      \"TEST1B23QDM1\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"TEST1US00752M1018\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_natural_id\": \"TEST112422410\",\n" +
                "    \"p_website\": \"www.testabtlafleur.com\",\n" +
                "    \"p_natural_id_type\": \"BBG\",\n" +
                "    \"p_isDeprecated\": \"true\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"Test1 Company Name3\",\n" +
                "    \"Test1 Company Name1\",\n" +
                "    \"Test1 Company Name2\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"version\": 1,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_bbg\": \"testd1464edac0c62c62ec214a0919bdc067\"\n" +
                "  }\n" +
                "}";

        Assert.assertTrue(JSONCompare.jsonObjectEquals(new JSONObject(json1), new JSONObject(json2), Lists.newArrayList("id", "version")));
    }

    @Test
    public void test_pausan() {
        String json1_titan = "{\n" +
                "  \"id\": \"54587568\",\n" +
                "  \"uri\": \"http://gs.com/lex/corporate/abbvie_inc\",\n" +
                "  \"name\": \"AbbVie Inc\",\n" +
                "  \"entityType\": \"corporate\",\n" +
                "  \"identifiers\": {\n" +
                "    \"i_name_jp\": \"アッヴィ\",\n" +
                "    \"i_wikidata_perm_id\": [\n" +
                "      \"5037613143\"\n" +
                "    ],\n" +
                "    \"i_wikidata_LEI\": [\n" +
                "      \"FR5LCKFTG8054YNNRU85\"\n" +
                "    ],\n" +
                "    \"i_ric\": [\n" +
                "      \"ABBV.PA\",\n" +
                "      \"4AB.F\",\n" +
                "      \"ABBV.S\",\n" +
                "      \"ABBV34.SA\",\n" +
                "      \"ABBV.N\",\n" +
                "      \"ABBV.MX\"\n" +
                "    ],\n" +
                "    \"i_dbpedia_uri\": [\n" +
                "      \"\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"00287Y109\"\n" +
                "    ],\n" +
                "    \"i_wikidata_isin\": [\n" +
                "      \"US00287Y1091\"\n" +
                "    ],\n" +
                "    \"i_wikidata_link\": [\n" +
                "      \"http://en.wikipedia.org/wiki/AbbVie_Inc.\"\n" +
                "    ],\n" +
                "    \"i_bid\": [\n" +
                "      \"EQ0000000045454838\",\n" +
                "      \"EQ0000000020553113\",\n" +
                "      \"EQ0000000028428870\",\n" +
                "      \"EQ0000000032374640\",\n" +
                "      \"EQ0000000037744783\",\n" +
                "      \"EQ0000000049228836\",\n" +
                "      \"EQ0000000032375138\",\n" +
                "      \"EQ0000000027662940\",\n" +
                "      \"EQ0000000027596069\",\n" +
                "      \"EQ0000000027907965\"\n" +
                "    ],\n" +
                "    \"i_ticker\": [\n" +
                "      \"ABBV\"\n" +
                "    ],\n" +
                "    \"i_lei_number\": [\n" +
                "      \"FR5LCKFTG8054YNNRU85\"\n" +
                "    ],\n" +
                "    \"i_bond_ticker\": [\n" +
                "      \"ABBV\"\n" +
                "    ],\n" +
                "    \"i_sedol\": [\n" +
                "      \"B92SR70\"\n" +
                "    ],\n" +
                "    \"i_wikidata_id\": [\n" +
                "      \"Q14662364\"\n" +
                "    ],\n" +
                "    \"i_prime_id\": [\n" +
                "      \"372119936\",\n" +
                "      \"371436712\",\n" +
                "      \"371504401\",\n" +
                "      \"373676654\",\n" +
                "      \"371445485\",\n" +
                "      \"371415893\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"US00287Y1091\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_perspective_parent\": [\n" +
                "      \"http://gs.com/lex/wiki/q14662364\"\n" +
                "    ],\n" +
                "    \"p_natural_id\": \"28046509\",\n" +
                "    \"p_website\": \"www.abbvie.com\",\n" +
                "    \"p_natural_id_type\": \"BBG\",\n" +
                "    \"p_perspective_bbg_child\": [\n" +
                "      \"http://gs.com/lex/emmacorporate/20374574_abbvie_inc\"\n" +
                "    ],\n" +
                "    \"p_perspective\": [\n" +
                "      \"p_perspective_bbg_child\",\n" +
                "      \"p_perspective_parent\"\n" +
                "    ],\n" +
                "    \"p_isDeprecated\": \"false\",\n" +
                "    \"p_isCovered\": \"true\",\n" +
                "    \"p_covered_by_desk\": [\n" +
                "      \"FE US Equity|28046509\",\n" +
                "      \"FI Investment Grade|ABBV\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"AbbVie Inc.\",\n" +
                "    \"ABBVIE\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"version\": 0,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_bbg\": \"5787be29672e58e114dfaf91b37d459e\"\n" +
                "  }\n" +
                "}";

        String json2_cass = "{\n" +
                "  \"id\": \"73925db5-9695-39f4-b149-80b6a7f85637\",\n" +
                "  \"uri\": \"http://gs.com/lex/corporate/abbvie_inc\",\n" +
                "  \"name\": \"AbbVie Inc\",\n" +
                "  \"entityType\": \"corporate\",\n" +
                "  \"identifiers\": {\n" +
                "    \"i_name_jp\": \"アッヴィ\",\n" +
                "    \"i_wikidata_perm_id\": [\n" +
                "      \"5037613143\"\n" +
                "    ],\n" +
                "    \"i_ric\": [\n" +
                "      \"4AB.F\",\n" +
                "      \"ABBV.MX\",\n" +
                "      \"ABBV.N\",\n" +
                "      \"ABBV.PA\",\n" +
                "      \"ABBV.S\",\n" +
                "      \"ABBV34.SA\"\n" +
                "    ],\n" +
                "    \"i_wikidata_LEI\": [\n" +
                "      \"FR5LCKFTG8054YNNRU85\"\n" +
                "    ],\n" +
                "    \"i_dbpedia_uri\": [\n" +
                "      \"\"\n" +
                "    ],\n" +
                "    \"i_cusip\": [\n" +
                "      \"00287Y109\"\n" +
                "    ],\n" +
                "    \"i_wikidata_isin\": [\n" +
                "      \"US00287Y1091\"\n" +
                "    ],\n" +
                "    \"i_wikidata_link\": [\n" +
                "      \"http://en.wikipedia.org/wiki/AbbVie_Inc.\"\n" +
                "    ],\n" +
                "    \"i_bid\": [\n" +
                "      \"EQ0000000020553113\",\n" +
                "      \"EQ0000000027596069\",\n" +
                "      \"EQ0000000027662940\",\n" +
                "      \"EQ0000000027907965\",\n" +
                "      \"EQ0000000028428870\",\n" +
                "      \"EQ0000000032374640\",\n" +
                "      \"EQ0000000032375138\",\n" +
                "      \"EQ0000000037744783\",\n" +
                "      \"EQ0000000045454838\",\n" +
                "      \"EQ0000000049228836\"\n" +
                "    ],\n" +
                "    \"i_ticker\": [\n" +
                "      \"ABBV\"\n" +
                "    ],\n" +
                "    \"i_bond_ticker\": [\n" +
                "      \"ABBV\"\n" +
                "    ],\n" +
                "    \"i_lei_number\": [\n" +
                "      \"FR5LCKFTG8054YNNRU85\"\n" +
                "    ],\n" +
                "    \"i_sedol\": [\n" +
                "      \"B92SR70\"\n" +
                "    ],\n" +
                "    \"i_wikidata_id\": [\n" +
                "      \"Q14662364\"\n" +
                "    ],\n" +
                "    \"i_prime_id\": [\n" +
                "      \"371415893\",\n" +
                "      \"371436712\",\n" +
                "      \"371445485\",\n" +
                "      \"371504401\",\n" +
                "      \"372119936\",\n" +
                "      \"373676654\"\n" +
                "    ],\n" +
                "    \"i_isin\": [\n" +
                "      \"US00287Y1091\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"attributes\": {},\n" +
                "  \"properties\": {\n" +
                "    \"p_perspective_parent\": [\n" +
                "      \"http://gs.com/lex/wiki/q14662364\"\n" +
                "    ],\n" +
                "    \"p_natural_id\": \"28046509\",\n" +
                "    \"p_website\": \"www.abbvie.com\",\n" +
                "    \"p_natural_id_type\": \"BBG\",\n" +
                "    \"p_perspective_bbg_child\": [\n" +
                "      \"http://gs.com/lex/emmacorporate/20374574_abbvie_inc\"\n" +
                "    ],\n" +
                "    \"p_perspective\": [\n" +
                "      \"p_perspective_bbg_child\",\n" +
                "      \"p_perspective_parent\"\n" +
                "    ],\n" +
                "    \"p_isDeprecated\": \"false\",\n" +
                "    \"p_covered_by_desk\": [\n" +
                "      \"FE US Equity|28046509\",\n" +
                "      \"FI Investment Grade|ABBV\"\n" +
                "    ],\n" +
                "    \"p_isCovered\": \"true\"\n" +
                "  },\n" +
                "  \"synonyms\": [\n" +
                "    \"AbbVie Inc.\",\n" +
                "    \"ABBVIE\"\n" +
                "  ],\n" +
                "  \"softDeleted\": false,\n" +
                "  \"usedForSearch\": true,\n" +
                "  \"version\": 1,\n" +
                "  \"md5HashValues\": {\n" +
                "    \"md5_hash_bbg\": \"5787be29672e58e114dfaf91b37d459e\"\n" +
                "  }\n" +
                "}";

        Assert.assertTrue(JSONCompare.jsonObjectEquals(new JSONObject(json1_titan),
                new JSONObject(json2_cass), Lists.newArrayList("id", "version", "docCount", "docCountDate")));

    }
}