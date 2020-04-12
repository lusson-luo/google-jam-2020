**Problem**

Cameron and Jamie's kid is almost 3 years old! However, even though the child is more independent now, scheduling kid activities and domestic necessities is still a challenge for the couple.

Cameron and Jamie have a list of N activities to take care of during the day. Each activity happens during a specified interval during the day. They need to assign each activity to one of them, so that neither of them is responsible for two activities that overlap. An activity that ends at time t is not considered to overlap with another activity that starts at time t.

For example, suppose that Jamie and Cameron need to cover 3 activities: one running from 18:00 to 20:00, another from 19:00 to 21:00 and another from 22:00 to 23:00. One possibility would be for Jamie to cover the activity running from 19:00 to 21:00, with Cameron covering the other two. Another valid schedule would be for Cameron to cover the activity from 18:00 to 20:00 and Jamie to cover the other two. Notice that the first two activities overlap in the time between 19:00 and 20:00, so it is impossible to assign both of those activities to the same partner.

Given the starting and ending times of each activity, find any schedule that does not require the same person to cover overlapping activities, or say that it is impossible.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line containing a single integer N, the number of activities to assign. Then, N more lines follow. The i-th of these lines (counting starting from 1) contains two integers Si and Ei. The i-th activity starts exactly Si minutes after midnight and ends exactly Ei minutes after midnight.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is IMPOSSIBLE if there is no valid schedule according to the above rules, or a string of exactly N characters otherwise. The i-th character in y must be C if the i-th activity is assigned to Cameron in your proposed schedule, and J if it is assigned to Jamie.

If there are multiple solutions, you may output any one of them. (See "What if a test case has multiple correct solutions?" in the Competing section of the FAQ. This information about multiple solutions will not be explicitly stated in the remainder of the 2020 contest.)

Limits

- Time limit: 20 seconds per test set.
- Memory limit: 1GB.
- 1 ≤ T ≤ 100.
- 0 ≤ Si < Ei ≤ 24 × 60.

Test set 1 (Visible Verdict)

2 ≤ N ≤ 10.

Test set 2 (Visible Verdict)

2 ≤ N ≤ 1000.

Sample

Input

```
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
```

Output

```
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC
```

Sample Case #1 is the one described in the problem statement. As mentioned above, there are other valid solutions, like JCJ and JCC.

In Sample Case #2, all three activities overlap with each other. Assigning them all would mean someone would end up with at least two overlapping activities, so there is no valid schedule.

In Sample Case #3, notice that Cameron ends an activity and starts another one at minute 100.

In Sample Case #4, any schedule would be valid. Specifically, it is OK for one partner to do all activities.

**大致意思**

给定一列活动的时间段，把这些计划分配给C和J两个人去完成，但是一个人不能同时完成拥有时间冲突的两项活动。如有三个活动18:00 - 20:00,  19:00 - 21:00 和 22:00 - 23:00，一种安排方式是C去完成18:00 - 20:00这个活动，J去完成19:00 - 21:00 和 22:00 - 23:00这两个活动。当然，C去完成19:00 - 21:00 和 22:00 - 23:00，J去完成18:00 - 20:00也是可以的。如果有三个活动的时间段互相冲突，则这些活动就无法被分配，如18:00 - 20:00,  19:00 - 21:00，19:00 - 22:00。

可以安排的活动列表，输出活动由C和J的一种执行顺序；如果活动列表不能分配，输出`IMPOSSIBLE`。

*输入*

```
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
```

*输出*

```
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC
```


**解题思路**

这题我没有做对，思路错误。

正确思路可能是，每进一个新的活动，判断是否A，B列表是否都存在与之冲突的活动，都不存在则插入队列A；如果A存在，B不存在则插入队列B；如果A，B中都存在冲突的活动，将这些冲突的活动都拿出来比较，查看它们之间是否互相冲突，如果冲突则说明活动无法安排；如果不冲突，则把这些活动放到队列B中（如果B中有冲突，放入A，把A冲突翻入B，直到没有冲突），把插入的活动放到A。                                  