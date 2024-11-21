## ProgressIndicator

This is a customizable circular progress bar. You can achieve the arc progress effect with text in the center using only XML.

**Contents**

*   [Circular Progress Indicator](#circularprogressindicator)
*   [Arc Progress Indicator](#arcprogressindicator)

### Add Dependency in Gradle

```groovy
dependencies {
    implementation("com.github.ghxstbyte:progress-indicator:1.0.0")

}
```


### CircularProgressIndicator

![CircularProgressIndicator](example/CircularProgressIndicator.jpg)

```xml
<com.arr.arcprogressbar.CircularProgressIndicator
    android:id="@+id/progress_circular"
    android:layout_width="140dp"
    android:layout_height="140dp" />
```

### ArcProgressIndicator

![ArcProgressIndicator](example/ArcProgressIndicator.jpg)

```xml
<com.arr.arcprogressbar.ArcProgressIndicator
    android:id="@+id/progress_arc"
    android:layout_width="140dp"
    android:layout_height="140dp" />
```

### Common attributes
The following attributes are shared between arc progress and circular progress indicators:

|Element|Attribute|Related method(s)|Default value|
|:---:|:---:|:---:|:---:|
|Indicator color|app:colorProgress|setProgressColor|Color.BLUE
|Animation|app:arcAnimation|N/A|false
|Stroke width|app:strokeWidth|setStrokeWidth|10dp
|Text label|app:centerText|setCenterText|null
|Text color|app:centerTextColor|setTextColor|Color.BLACK
|Text size|app:textSize|setTextSize|12dp


### License 
```md
MIT License

Copyright (c) 2024 Alessandro

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```