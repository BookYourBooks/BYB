package com.example.byb.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.byb.Interface.ItemClickListener;
import com.example.byb.R;

public class Documentviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView usn,copies,link, description;
    private ItemClickListener itemClickListener;



    public Documentviewholder(@NonNull View itemView)
    {
        super(itemView);

        usn= itemView.findViewById(R.id.document_link_usn);
        copies = itemView.findViewById(R.id.document_number_of_copies);
        link = itemView.findViewById(R.id.document_link);
        description=itemView.findViewById(R.id.document_link_description);
    }

    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view, getAdapterPosition() , false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }
}

