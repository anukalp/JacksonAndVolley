
package com.android.mcafee.apphub.model;

import com.android.mcafee.apphub.filter.CustomFilter;
import com.android.mcafee.apphub.filter.FilterUtils;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link AppHubDetailsJsonData} is used to removed redundancy while inflating
 * list/details
 * 
 * @author Anukalp
 **/
public class AppHubDetailsJsonData extends AppHubListLoaderData implements
        Comparable<AppHubDetailsJsonData>, Parcelable {

    public static final String TAG_IMAGE = "imagee";

    public static final String TAG_TYPE = "type";

    public static final String TAG_USERS = "users";

    public static final String TAG_UPDATE = "last_update";

    public static final String TAG_DESCRIPTION = "description";

    public static final String TAG_GOOGLE_PLAY = "url";

    private String imagee;

    public void setImagee(String imagee) {
        this.imagee = imagee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public void setUsers(long users) {
        this.users = users;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String type;

    private String last_update;

    private long users;

    private String description;

    private String url;

    public AppHubDetailsJsonData() {
        super();
    }

    private AppHubDetailsJsonData(Parcel in) {
        super(in);
        imagee = in.readString();
        type = in.readString();
        users = in.readLong();
        last_update = in.readString();
        description = in.readString();
        url = in.readString();
    }

    public String getImageURL() {
        return imagee;
    }

    public String getType() {
        return type;
    }

    public String getLastUpdate() {
        return last_update;
    }

    public long getUsers() {
        return users;
    }

    public String getGooglePlayURL() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AppHubDetailsJsonData [mImageURL=" + imagee + ", mType=" + type + ", mLastUpdate="
                + last_update + ", mUsers=" + users + ", mDescription=" + description
                + ", mGooglePlayURL=" + url + ", toString()=" + super.toString() + "]";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(imagee);
        dest.writeString(type);
        dest.writeLong(users);
        dest.writeString(last_update);
        dest.writeString(description);
        dest.writeString(url);
    }

    @Override
    public int compareTo(AppHubDetailsJsonData another) {
        ContentValues values = CustomFilter.getInstance().getCurrentFilter();
        if (!values.containsKey(FilterUtils.TAG_FILTER_TYPE_PRICE)
                || values.getAsBoolean(FilterUtils.TAG_FILTER_TYPE_PRICE)) {
            return another.getPrice() > this.getPrice() ? -1 : 0;
        } else {
            return another.getRating() > this.getRating() ? -1 : 0;
        }

    }

    public static final Parcelable.Creator<AppHubDetailsJsonData> CREATOR = new Parcelable.Creator<AppHubDetailsJsonData>() {
        public AppHubDetailsJsonData createFromParcel(Parcel in) {
            return new AppHubDetailsJsonData(in);
        }

        public AppHubDetailsJsonData[] newArray(int size) {
            return new AppHubDetailsJsonData[size];
        }
    };

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }
}
