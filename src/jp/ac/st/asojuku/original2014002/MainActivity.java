package jp.ac.st.asojuku.original2014002;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnOK = (Button)findViewById(R.id.btnOK);
		btnOK.setOnClickListener(this);
		Button btnMNT = (Button)findViewById(R.id.btnMNT);
		btnMNT.setOnClickListener(this);

	}
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.btnMNT:
			//EditText etv = (EditText)findViewById(R.id.edtName);
			//String inputMsg = etv.getText().toString();
			Intent intent = null;
			intent = new Intent(MainActivity.this, MntActivity.class);
			startActivity(intent);
			break;
		case R.id.btnOK:
			intent = new Intent(MainActivity.this, HitokotoActivity.class);
			startActivity(intent);
			break;

			}


		}
	}

