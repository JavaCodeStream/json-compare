# json-compare
A JSON utility to compare 2 JSONs

Provides utility functions to perform Comparison between 2 JSON Strings / JSONObjects /JSONArrays
Implementation does a deep comparison on 2 given JSON.
Considerations:
1. Returns true only if the JSONs are exactly the same
2. The keys don't have to be in the same order for the two JSON's to be equal.
3. Array elements don't have to be in same order for the JSON's to be equal.
4. Optional param to ignore specific keys while comparison
