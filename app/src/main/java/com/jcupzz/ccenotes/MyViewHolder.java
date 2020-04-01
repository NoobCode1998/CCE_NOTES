package com.jcupzz.ccenotes;

import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

public static String ve;
TextView mName;
    Button mDownload;

    CardView mCardView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        mName = itemView.findViewById(R.id.name);
        mDownload = itemView.findViewById(R.id.down);
mCardView= itemView.findViewById(R.id.cardview_id);
mCardView.setOnCreateContextMenuListener(this);



}

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(StudentTeacherCategory.stc_integer==2) {
            menu.add(getAdapterPosition(), 121, 0, "Delete");
            ve = mName.getText().toString();
        }
    }
}
