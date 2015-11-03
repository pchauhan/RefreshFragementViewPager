# RefreshFragementViewPager


RefreshFragementViewPager is useful for update fragment on Tab change using FragmentStatePagerAdapter.

 - [FragmentPagerAdapter][1] (The main advantage of using Android FragmentPagerAdapter is that, it keeps the fragment in memory. This definitely increases the memory usage, therefore it is advised to use Android FragmentPagerAdapter only when there are less number of fragments. If you app has non changing fragments like, fragments with images or static text it might work even better. But using Android FragmentPagerAdapter for large number of fragments would result choppy and laggy UX.)
 
 - [FragmentStatePagerAdapter][2]  (Since the main purpose/advantage of Android FragmentStatePagerAdapter class is to it consume less memory as compared to its counterpart, I used this to solve my problem. Android FragmentStatePagerAdapter class consumes less memory, because it destroys fragments, as soon as they are not visible to user, keeping only saved state of that fragment. And savedInstanceState is all, what I needed in my app to restore the filled out data by user.)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RefreshFragementViewPager-green.svg?style=true)](https://android-arsenal.com/details/3/2723)

## Screenshot

![1](https://raw.githubusercontent.com/pchauhan/RefreshFragementViewPager/master/Screenshots/1.png)![2](https://raw.githubusercontent.com/pchauhan/RefreshFragementViewPager/master/Screenshots/2.png)


you can download to see example  for more understanding.

##Compatibility

 - Android 2.3.3+
 


  [1]: http://developer.android.com/reference/android/support/v4/app/FragmentPagerAdapter.html
  [2]: https://developers.google.com/places/documentation/search
 




##License
The MIT License (MIT)

Copyright (c) 2015 Parag Chauhan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
