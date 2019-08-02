package com.example.studybuddy;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    private OnNoteListener mOnNoteListener;

    public SubjectAdapter(Context context, Cursor cursor,OnNoteListener onNoteListener){
        mContext = context;
        mCursor = cursor;
        mOnNoteListener = onNoteListener;
    }
    public class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView subjectName;
        public TextView subjectCredits;
        public OnNoteListener onNoteListener;
        public SubjectViewHolder(@NonNull View itemView,OnNoteListener onNoteListener) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subject_name_item);
            subjectCredits = itemView.findViewById(R.id.subject_credits_item);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.subject_view,viewGroup,false);
        return new SubjectViewHolder(view,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int i) {
        if(!mCursor.moveToPosition(i)){
            return;
        }
        String subjectName = mCursor.getString(mCursor.getColumnIndex(SubjectTable.SubjectEntries.SUBJECT_NAME));
        String subjectCredits = mCursor.getString(mCursor.getColumnIndex(SubjectTable.SubjectEntries.SUBJECT_CREDITS));

        holder.subjectName.setText(subjectName);
        holder.subjectCredits.setText(subjectCredits);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor cursor){
        if(mCursor!=null){
            mCursor.close();
        }
        mCursor = cursor;
        if(cursor!=null){
            notifyDataSetChanged();
        }
    }
}
