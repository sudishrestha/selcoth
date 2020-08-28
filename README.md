To Get Started \

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
    implementation 'com.github.sudishrestha:selcoth:v0.0.1'
	}
  
Step 3.  Add permision on manifest for camera
      
    <uses-permission android:name="android.permission.INTERNET" />
        
  Step 4. Add the element in the xml file
  
    <np.com.sudishrestha.selcouthstreamer.streamer
        android:layout_width="match_parent"
        android:id="@+id/mystream"
        android:layout_height="match_parent"/>
   
   Step 5. Add some code in the activity
   
  public class MainActivity extends AppCompatActivity implements  streamInterface {
      np.com.sudishrestha.selcouthstreamer.streamer streamer;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          getSupportActionBar().hide();
          this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

          setContentView(R.layout.activity_main);
          streamer = findViewById(R.id.mystream);
          streamer.setMstreamInterface(this);


      }

      @Override
      public void onClick(String username, String type, String info) {
          Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
      }
  }
  
  If any problem with the running of code, check for the permission in app
   
   
   Sample output  
   
   <img width="200" alt="screenshots" src="https://raw.githubusercontent.com/sudishrestha/selcoth/master/app/src/main/res/drawable/demo.png"> 
 
   
