**Problem**

tl;dr: Given a string of digits S, insert a minimum number of opening and closing parentheses into it such that the resulting string is balanced and each digit d is inside exactly d pairs of matching parentheses.

Let the nesting of two parentheses within a string be the substring that occurs strictly between them. An opening parenthesis and a closing parenthesis that is further to its right are said to match if their nesting is empty, or if every parenthesis in their nesting matches with another parenthesis in their nesting. The nesting depth of a position p is the number of pairs of matching parentheses m such that p is included in the nesting of m.

For example, in the following strings, all digits match their nesting depth: 0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1). The first three strings have minimum length among those that have the same digits in the same order, but the last one does not since ((22)1) also has the digits 221 and is shorter.

Given a string of digits S, find another string S', comprised of parentheses and digits, such that:
all parentheses in S' match some other parenthesis,
removing any and all parentheses from S' results in S,
each digit in S' is equal to its nesting depth, and
S' is of minimum length.

Input
The first line of the input gives the number of test cases, T. T lines follow. Each line represents a test case and contains only the string S.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the string S' defined above.

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ length of S ≤ 100.

Test set 1 (Visible Verdict)
Each character in S is either 0 or 1.

Test set 2 (Visible Verdict)
Each character in S is a decimal digit between 0 and 9, inclusive.

Sample

Input

Output

4
0000
101
111000
1


Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)


The strings ()0000(), (1)0(((()))1) and (1)(11)000 are not valid solutions to Sample Cases #1, #2 and #3, respectively, only because they are not of minimum length. In addition, 1)( and )(1 are not valid solutions to Sample Case #4 because they contain unmatched parentheses and the nesting depth is 0 at the position where there is a 1.

You can create sample inputs that are valid only for Test Set 2 by removing the parentheses from the example strings mentioned in the problem statement.

**大致意思**

给定一串纯数字的字符串，在每个字符串左右加上数量相同的左右括号，括号的深度和数字相同，如`((2))`多个数字之间的括号可以合并，如`((2(3)))`。给出一个字符串，求出符合条件的加括号的字符串中长度最短的字符串。如`0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1)`都是符合条件的字符串，但是第四个不是最短的，因为` ((22)1)`更短，案例：

*输入*

```
4
0000
101
111000
1
```

*输出*

```
Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)
```

**解题思路**

这道题我的解题思路是，把字符串分一个数字数组，从第一个数字开始，添加`()`形成字符串，再把下一个数字加入进来，继续处理新的`()`，用例子说明容易理解一点。比如对应字符串`312`，处理逻辑分3步。

- 第一步：把`3`处理括号得到`(((3)))`

- 第二步：把`(((3)))`加入第二个数`1`得到`(((3))1)`
- 第三步：把`(((3))1)`加入第三个数`2`得到`(((3))1(2))`

这个加新数得到最短长度的深度括号的字符串的逻辑是这样的，如`AB`数加`C`，分`B<C`, `B==C`, `B>C`三种情况处理括号。

- `B < C`: `B`右侧的`C`个`)`移动到`C`的右侧。如`((2))`加新数字`1`后为，将`2`右侧的`1`个`)`移动到`1`的右侧，得到`((2)1)`。
- `B == C`: `B`右侧所有的`)`都移动到`C`的右侧。如`((2))`加新数字`1`后为`((22))`。
- `B < C`: `B`右侧的`)`全部删除，添加`C - B`个`(`，`C`右侧添加`C`个`)`。如`((2))`加新数字`3`的步骤，1. 删除`2`右边的`)`，得`((23`；2. `2`右边添加`3 - 2`个`(`，的`((2(3`；3. `3`右侧添加`3`次个`)`，得`((2(3)))`。

不断加新数并按上面的逻辑的到新字符串，直到所有的数字都添加完，就得到最终的最短的字符串。
                                                  