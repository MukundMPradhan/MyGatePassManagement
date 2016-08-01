package in.app.myandroid.mygatepassmanagement.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.model.GatePass;

/**
 * Created by mukund on 24/7/16.
 */

public class RVAdapter_AllPasses extends RecyclerView.Adapter<RVAdapter_AllPasses.MemberViewHolder> {
    private ArrayList<GatePass> allPasses;
    Context mContext;

    public RVAdapter_AllPasses(ArrayList<GatePass> allPasses, Context mContext) {
        this.allPasses = allPasses;
        this.mContext = mContext;
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {
        //   private ImageView profilePhoto;
        private TextView personName, refNo, validity, passType, expiredDate;
        private TextView status, approvedOn;


        public MemberViewHolder(View itemView) {
            super(itemView);
            //    profilePhoto = (ImageView) itemView.findViewById(R.id.imgListProfilePhoto);
            personName = (TextView) itemView.findViewById(R.id.tvListItemName);
            refNo = (TextView) itemView.findViewById(R.id.ansListItemRefNo);
            validity = (TextView) itemView.findViewById(R.id.ansListItemValidity);
            passType = (TextView) itemView.findViewById(R.id.ansListItemPassType);
            expiredDate = (TextView) itemView.findViewById(R.id.ansListItemExpiredDt);
            status = (TextView) itemView.findViewById(R.id.ansListItemStatus);
            approvedOn = (TextView) itemView.findViewById(R.id.ansListItemAproved);

        }
    }


    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item_pass, parent, false);

        MemberViewHolder memberViewHolder = new MemberViewHolder(view);

        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {
        // holder.profilePhoto.setImageResource(allPasses.get(position).getOwner_photo().);
        holder.personName.setText(allPasses.get(position).getFast_name() + " " + allPasses.get(position).getLast_name());
        holder.refNo.setText(allPasses.get(position).getRef_id());
        holder.validity.setText(allPasses.get(position).getPass_period());
        holder.passType.setText(allPasses.get(position).getPass_type());
        //hol
        holder.status.setText(allPasses.get(position).getMod_status());
        holder.approvedOn.setText(allPasses.get(position).getAccept_date());
    }


    @Override
    public int getItemCount() {
        return allPasses.size();
    }
}


//        ImageView imgPhoto;
//        TextView name,refNo, validity, passType, expired, status, approved;
//
//        imgPhoto = (ImageView) convertView.findViewById(R.id.imgListItemPhoto);
//        name = (TextView) convertView.findViewById(R.id.tvListItemName);
//        refNo = (TextView) convertView.findViewById(R.id.ansListItemRefNo);
//        validity = (TextView) convertView.findViewById(R.id.ansListItemValidity);
//        passType = (TextView) convertView.findViewById(R.id.ansListItemPassType);
//        expired = (TextView) convertView.findViewById(R.id.ansListItemExpiredDt);
//        status = (TextView) convertView.findViewById(R.id.ansListItemStatus);
//        approved = (TextView) convertView.findViewById(R.id.ansListItemAproved);
//
//
//        GatePass newPass = allPasses.get(position);
//        //imgPhoto.setImageResource();
//
//        name.setText(newPass.getFast_name() + " " + newPass.getLast_name());







