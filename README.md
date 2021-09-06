**Shift:** Read values or portions of the input JSON tree and add them to specified locations in the output.

**Default:** Non-destructively adds values or arrays of values to the output JSON.

**Cardinality:** Transforms elements in the input JSON to single values or to arrays (lists) in the output.

**Remove:** Remove elements if found in the input JSON.

**Modify:** Write calculated values to elements in the target JSON. Calculations include basic string and math operations (toLower, toUpper, concat, min/max/abs, toInteger, toDouble, toLong and can be applied to source JSON values.

**Sort:** Sorts all arrays and maps from the input JSON into the output. Sort cannot be configured beyond this all-or-nothing sort. Let’s put the jelly first to make it easier to spread on the bread later:

### **Wildcards and Operators:**
**_1.Input-side (lefthand side):_**

Input-side wildcards retrieve a value or JSON tree from the input JSON.
* \* (asterisk)
  The asterisk wildcard traverses and reads each element in the source JSON at the level of the preceding search specification. Typically, the asterisk wildcard will return an array of elements.
* The asterisk wildcard can be used with other string characters to parse data within an input JSON element 
* The (@)“at” wildcard traverses backwards up the source JSON and returns the entire tree or value at the specified position.
* @ or @0 (return value or tree of the matched key from the input JSON)

**_2.Output-side (righthand side):_**

Output-side wildcards return a single value that can be used in a target JSON key, key path or value.

* & (ampersand)

  The ampersand wildcard traverses backwards up the source JSON tree, beginning at the level of the preceding match. It returns only the value or key name (not the tree). The ampersand can be used in three ways:
* & or &0 (return the name of the matched key from the input JSON)
* &n (walk back up the tree ‘n’ levels and return the key name from the specified level)
* &(n,x) (walk back up the tree ‘n’ levels and return the key name from the xth child of the key at that level)
* The “at” wildcard traverses backwards up the source JSON and returns the entire tree or value at the specified position. Same functionality as on the input side, above: @, @(n), @(keyName), and @(n,keyName) forms 
* $ (dollar sign)

  The dollar sign traverses backwards up the source JSON and returns only the value at the specified position. Same functionality as @, above: $, $(n), and $(n,x) forms


Writing different spec file means different passes. When the three passes are complete, the successful pass is written to the output as “particles” and the backup is removed with a “remove” operation.
