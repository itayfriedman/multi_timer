package itay.friedman.multi_trainees_timer;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MultiTimer extends Activity {

	private TimerListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multi_timer);
		
		setupListViewAdapter();
		
		setupAddTimerButton();
		
	  
	}
	
	public void removeTimerOnClickHandler(View v) {
		Mtimer itemToRemove = (Mtimer)v.getTag();
		adapter.remove(itemToRemove);
	}
	
	private void setupListViewAdapter() {
		adapter = new TimerListAdapter(MultiTimer.this, R.layout.listview_timer, new ArrayList<Mtimer>());
		ListView mtimerListView = (ListView)findViewById(R.id.timersList);
		mtimerListView.setAdapter(adapter);
	}
	
	private void setupAddTimerButton() {
		findViewById(R.id.addTimerButton).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				adapter.insert(new Mtimer("", 1, 1, 1), 0);
			}
		});
	}
	
}