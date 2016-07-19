
            android 数据双向绑定学习笔记


今天在网上看到了有关双向绑定，顿时，兴趣油然而生。小写一个demo

所谓数据双向绑定（dataBinding）,即界面，数据的双向改变（界面交互改变数据，也可数据修改同时修改界面显示）

下面，详细介绍双向帮定:

首先，双向绑定需在studio2.1-priview3之后的版本
    项目gradle需要是：
        classpath 'com.android.tools.build:gradle:2.2.0-alpha5'

其次，app 需要开启双向绑定，gradle 需设置
         android {
            ...
            dataBinding.enabled = true
         }

然后看代码：
   <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

        <data>
            <variable
                name="user"
                type="com.ecasona.entity.User"></variable>
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="10dp"
            android:orientation="vertical">

            <TextView
                android:id="@+id/title"
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:text="@{user.title}"
                android:textAppearance="@style/TextAppearance.AppCompat.Title"
                android:textColor="@color/primary_text" />

            <TextView
                android:id="@+id/description"
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_marginTop="2dp"
                android:text="@{user.description}"
                android:textColor="@color/secondary_text" />

            <Button
                android:id="@+id/btn"
                android:layout_width="match_parent"
                android:layout_height="60dp"
                android:layout_margin="20dp"
                android:text="点击" />

        </LinearLayout>
    </layout>

data 节点绑定实体类(type)，并且设定在xml中使用的字段(name)
         <data>
                <variable
                    name="user"
                    type="com.ecasona.entity.User">
                </variable>
         </data>

xml中的使用语法:@{user.title}...与jQuery相似的语法，
实体类：
    public class User extends BaseObservable {

        private String id;
        private String title;
        private String original_title;
        private String year;


        @Bindable
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
            notifyPropertyChanged(BR.title);
        }

        @Bindable
        public String getDescription() {
            return original_title + "\n" + year;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
            notifyPropertyChanged(BR.description);
        }

        public void setYear(String year) {
            this.year = year;
            notifyPropertyChanged(BR.description);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", original_title='" + original_title + '\'' +
                    ", year='" + year + '\'' +
                    '}';
        }

    }

   实体集成BaseObservable，需要双向绑定的数据，在get方法前用@Bindable标注，在set方法中使用notifyPropertyChanged
   即时修改数据。

最后是activity:
      采用 ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
      binding.setUser(user);
      实现双向绑定。


