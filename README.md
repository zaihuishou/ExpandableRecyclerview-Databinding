##ExpandableRecyclerview-Databinding

  An ExpandableRecyclerview for Databinding

##Screenshot
![effict](/Screenshots.gif)

##Gradle
compile 'com.zaihuishou:expandablerecycleradapter-databinding:1.0

##Maven
```
  <dependency>
  <groupId>com.zaihuishou</groupId>
  <artifactId>expandablerecycleradapter-databinding</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

##How to use

  * Enable databinding in you build.gradle
```
    android{
       dataBinding {
         enabled = true
          }
       }
```

* Expandable item Observable `extend` [BaseExpandableObservable](https://github.com/zaihuishou/ExpandableRecyclerview-Databinding/blob/master/library/src/main/java/com/zaihuishou/databinding/expandablerecycleradapter/observable/BaseExpandableObservable.java)

* Implement [BaseExpandableAdapter](https://github.com/zaihuishou/ExpandableRecyclerview-Databinding/blob/master/library/src/main/java/com/zaihuishou/databinding/expandablerecycleradapter/adapter/BaseExpandableAdapter.java) methods: `getItemLayout` `getItemViewType` `getVariable`

* For more details, please check demo

##License

 ```
 Copyright 2016 zaihuishou

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressor implied.See the License for the specific language governing permissions and limitations under the License.
```