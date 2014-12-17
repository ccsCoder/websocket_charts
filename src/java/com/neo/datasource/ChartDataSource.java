
package com.neo.datasource;

import com.neo.model.WorkTimings;
import java.util.Random;

/**
 *
 * @author neo
 */
public class ChartDataSource {
    public static WorkTimings[] getWeeklyWorkData() {
        Random randomizer = new Random(System.currentTimeMillis());
        WorkTimings []workTimings = new WorkTimings[5];
        
        String [] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        for(int i=0;i<days.length;i++) {
            workTimings[i] = new WorkTimings();
            workTimings[i].setDay(days[i]);
            workTimings[i].setEstimated(6);
            workTimings[i].setActual(randomizer.nextInt(7));
        }
        return workTimings;
    }
}
