package com.mygdx.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.Main;

public class AndroidLauncher extends AndroidApplication {
	private Button button;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useImmersiveMode = true;
		initialize(new Main(), config);

//		setContentView(R.layout.activity_first);
//		button = (Button) findViewById(R.id.button);
//		button.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				openactive2();
//			}
//	     });
	}

//		public  void openactive2(){
//			Intent intent = new Intent(this,Main.class);
//			startActivity(intent);
//		}
}
