package com.example.hikoya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionAdapter  extends RecyclerView.Adapter<VersionAdapter.VersionVH> {


    List<Version> versionList;

    public VersionAdapter(List<Version> versionList) {

        this.versionList = versionList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.row ,parent,false);
         return new VersionVH( view );
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull VersionAdapter.VersionVH holder, int position) {
             Version version = versionList.get( position );
             holder.codeNameTxt.setText( version.getCodeName() );
             holder.versionTxt.setText( version.getVersion() );
             boolean isExpandable =  versionList.get( position ).isExpandable();
             holder.expandablelayout.setVisibility( isExpandable? View.VISIBLE:View.GONE );
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {
        TextView codeNameTxt,versionTxt;
        LinearLayout linearLayout;
       RelativeLayout expandablelayout;

        public VersionVH( View itemView) {
            super( itemView );
            codeNameTxt = itemView.findViewById( R.id.code_name );
            versionTxt =  itemView.findViewById( R.id.version );
            linearLayout = itemView.findViewById( R.id.linear_layout);
            expandablelayout = itemView.findViewById( R.id.expandable_layout );

            linearLayout.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Version versions;

                    versions = versionList.get(getAdapterPosition() );
                     versions.setExpandable(!versions.isExpandable() );
                     notifyItemChanged(getAdapterPosition());
                }
            } );
        }
    }
}
