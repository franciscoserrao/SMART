package com.example.avjindersinghsekhon.minimaltodo.Utility;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.RecyclerView;
// @SuppressWarnings("deprecation")
// @Override
// public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
// if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
// View itemView = viewHolder.itemView;
// Paint p = new Paint();
// 
// 
// MainActivity.BasicListAdapter.ViewHolder vh= (MainActivity.BasicListAdapter.ViewHolder)viewHolder;
// p.setColor(recyclerView.getResources().getColor(R.color.primary_light));
// 
// if(dX > 0){
// c.drawRect((float)itemView.getLeft(), (float)itemView.getTop(), dX, (float)itemView.getBottom(), p);
// String toWrite = "Left"+itemView.getLeft()+" Top "+itemView.getTop()+" Right "+dX+" Bottom "+itemView.getBottom();
// //                Log.d("OskarSchindler", toWrite);
// }
// else{
// String toWrite = "Left"+(itemView.getLeft()+dX)+" Top "+itemView.getTop()+" Right "+dX+" Bottom "+itemView.getBottom();
// //                Log.d("OskarSchindler", toWrite);
// c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom(), p);
// }
// super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
// }
// }
public class ItemTouchHelperClass extends android.support.v7.widget.helper.ItemTouchHelper.Callback {
    private com.example.avjindersinghsekhon.minimaltodo.Utility.ItemTouchHelperClass.ItemTouchHelperAdapter adapter;

    public interface ItemTouchHelperAdapter {
        void onItemMoved(int fromPosition, int toPosition);


        void onItemRemoved(int position);

    }

    public ItemTouchHelperClass(com.example.avjindersinghsekhon.minimaltodo.Utility.ItemTouchHelperClass.ItemTouchHelperAdapter ad) {
        adapter = ad;
    }


    @java.lang.Override
    public boolean isLongPressDragEnabled() {
        return true;
    }


    @java.lang.Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }


    @java.lang.Override
    public int getMovementFlags(android.support.v7.widget.RecyclerView recyclerView, android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        int upFlags = android.support.v7.widget.helper.ItemTouchHelper.UP | android.support.v7.widget.helper.ItemTouchHelper.DOWN;
        int swipeFlags = android.support.v7.widget.helper.ItemTouchHelper.START | android.support.v7.widget.helper.ItemTouchHelper.END;
        return android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags(upFlags, swipeFlags);
    }


    @java.lang.Override
    public boolean onMove(android.support.v7.widget.RecyclerView recyclerView, android.support.v7.widget.RecyclerView.ViewHolder viewHolder, android.support.v7.widget.RecyclerView.ViewHolder target) {
        adapter.onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }


    @java.lang.Override
    public void onSwiped(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemRemoved(viewHolder.getAdapterPosition());
    }

}