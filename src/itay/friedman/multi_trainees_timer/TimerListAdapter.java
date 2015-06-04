package itay.friedman.multi_trainees_timer;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

    
public class TimerListAdapter extends ArrayAdapter<Mtimer> {

protected static final String LOG_TAG = TimerListAdapter.class.getSimpleName();
	
	private List<Mtimer> items;
	private int layoutResourceId;
	private Context context;

	public TimerListAdapter(Context context, int layoutResourceId, List<Mtimer> items) {
		super(context, layoutResourceId, items);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.items = items;
	}

	@SuppressLint("ViewHolder") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		MtimerHolder holder = null;

		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);

		holder = new MtimerHolder();
		holder.multiTimer = items.get(position);
		holder.removePaymentButton = (Button)row.findViewById(R.id.btnRemove);
		holder.removePaymentButton.setTag(holder.multiTimer);

		holder.name = (TextView)row.findViewById(R.id.timer_name);
		setNameTextChangeListener(holder);
		holder.hour = (TextView)row.findViewById(R.id.hour);
		setHourTextListeners(holder);
		holder.min = (TextView)row.findViewById(R.id.min);
		setMinTextListeners(holder);
		holder.sec = (TextView)row.findViewById(R.id.sec);
		setSecTextListeners(holder);
		
		row.setTag(holder);

		setupItem(holder);
		return row;
	}

	private void setupItem(MtimerHolder holder) {
		holder.name.setText(holder.multiTimer.getName());
		holder.hour.setText(String.valueOf(holder.multiTimer.getHour()));
		holder.min.setText(String.valueOf(holder.multiTimer.getMin()));
		holder.sec.setText(String.valueOf(holder.multiTimer.getSec()));
	}

	public static class MtimerHolder {
		Mtimer multiTimer;
		TextView name;
		TextView hour;
		TextView min;
		TextView sec;
		Button removePaymentButton;
	}
	
	private void setNameTextChangeListener(final MtimerHolder holder) {
		holder.name.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				holder.multiTimer.setName(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

			@Override
			public void afterTextChanged(Editable s) { }
		});
	}

	private void setHourTextListeners(final MtimerHolder holder) {
		holder.hour.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				try{
					holder.multiTimer.setHour(Integer.parseInt(s.toString()));
				}catch (NumberFormatException e) {
					Log.e(LOG_TAG, "error reading hour: " + s.toString());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

			@Override
			public void afterTextChanged(Editable s) {
				Log.d(LOG_TAG, "reading hour: " + s.toString());
			}
		});
	}

	private void setMinTextListeners(final MtimerHolder holder) {
		holder.min.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				try{
					holder.multiTimer.setMin(Integer.parseInt(s.toString()));
				}catch (NumberFormatException e) {
					Log.e(LOG_TAG, "error reading min: " + s.toString());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

			@Override
			public void afterTextChanged(Editable s) { }
		});
	}

	private void setSecTextListeners(final MtimerHolder holder) {
		holder.sec.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				try{
					holder.multiTimer.setSec(Integer.parseInt(s.toString()));
				}catch (NumberFormatException e) {
					Log.e(LOG_TAG, "error reading sec: " + s.toString());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

			@Override
			public void afterTextChanged(Editable s) { }
		});
	}
	
}