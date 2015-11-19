package com.sharma.jitin.myappportfolio;

/**
 * Created by jitin on 19-11-2015.
 */
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ItemData[] itemsData;

    public MyAdapter(ItemData[] itemsData) {

        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout, parent, false);
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.button.setText(itemsData[position].getButtonText());
        if(position == 5){
            viewHolder.button.setBackgroundColor(R.color.material_deep_teal_200);
        }
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public Button button;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            button = (Button) itemLayoutView.findViewById(R.id.item_button);
            itemLayoutView.setClickable(true);
            itemLayoutView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(itemView.getContext(), "This button will launch " + button.getText().toString(),Toast.LENGTH_LONG).show();
            Snackbar.make(itemView,"This button will launch " + button.getText().toString(),Snackbar.LENGTH_LONG).show();
        }
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}