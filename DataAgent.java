package com.kyawhtut.athonesayin.util.network.api;

/**
 * Created by KyawHtut on 4/8/2018.
 */

public interface DataAgent {

    void getUsageDataFromServer(String user_id, String api_key);

    void getCategoryDataFromServer(String user_id, String api_key);

    void insertUser(
            String user_name,
            String user_id,
            String api_key,
            String user_profile,
            String user_email,
            int login_status,
            String user_address
    );

    void uploadCategoryDataToServer(
            String api_key,
            String user_id,
            int category_id,
            String category_name,
            String category_icon,
            int server_status,
            int server_status_id
    );

    void uploadUsageDataToServer(
            String api_key,
            String user_id,
            int usage_id,
            String usage_note,
            long usage_amount,
            long usage_time,
            String time_short,
            long created_time,
            long updated_time,
            int usage_status,
            int server_status,
            int category_id,
            int server_status_id
    );
}
