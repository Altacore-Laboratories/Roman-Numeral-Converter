# Roman-Numeral-Converter
This project is written entirely in Java &amp; is based around converting standard integers to roman numerals &amp; vice versa. This library was built entirely by me &amp; is highly accurate. I would really appreciate it if you give me improvement suggestions.

The class `RomanNumerals` is used for this operation, and it contains two methods for conversion.
- `RomanNumerals.toRoman(int num)` is a `static` method, and its used to convert an integer (up to a maximum of 3000) to roman numerals. It returns a value of type `String`.

Example:
```java
//Converts integers to roman numerals.
System.out.println(RomanNumerals.toRoman(2)); //Output: II
System.out.println(RomanNumerals.toRoman(4)); //Output: IV
System.out.println(RomanNumerals.toRoman(6)); //Output: VI
System.out.println(RomanNumerals.toRoman(8)); //Output: VIII
```

- `RomanNumerals.toNumber(String numerals)` is a `static` method, and its used to convert roman numerals to integers. It returns a value of type `int`.

Example:
```java
//Converts integers to roman numerals.
System.out.println(RomanNumerals.toNumber("II")); //Output: 2
System.out.println(RomanNumerals.toNumber("IV")); //Output: 4
System.out.println(RomanNumerals.toNumber("VI")); //Output: 6
System.out.println(RomanNumerals.toNumber("VIII")); //Output: 8
```

Overall, you can use this to convert numbers in high accuracy to & from roman numerals. I recommend copying the entire `system` folder into your project & modifying the packages if neccessary. Once the package is propely set, it should work fine.
