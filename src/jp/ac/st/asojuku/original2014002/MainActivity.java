package jp.ac.st.asojuku.original2014002;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

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
		Button btnCHECK = (Button)findViewById(R.id.btnCHECK);
		btnCHECK.setOnClickListener(this);



		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			return;
	}

	}
	@Override
	public void onClick(View v){
		Intent intent = null;
		switch(v.getId()){

		case R.id.btnOK:
			EditText etv = (EditText)findViewById(R.id.edtMsg);
			String inputMsg = etv.getText().toString();
			if(inputMsg!=null && !inputMsg.isEmpty()){
				helper.insertHitokoto(sdb, inputMsg);
			}
			etv.setText("");
			intent = new Intent(MainActivity.this, HitokotoActivity.class);
			startActivity(intent);
			break;

		case R.id.btnMNT:
			intent = new Intent(MainActivity.this, MntActivity.class);
			startActivity(intent);
			break;

		case R.id.btnCHECK:
			String strHitokoto = helper.selectRandomHitokoto(sdb);
			intent = new Intent(MainActivity.this, HitokotoActivity.class);
			intent.putExtra("hitokoto",strHitokoto);
			startActivity(intent);
		break;


			}


		}
	}

