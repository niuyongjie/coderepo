import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
* This ClassUtil will display days that conform Forgetting curve(艾宾浩斯遗忘曲线)
* like 1day ,2day, 5day, 8day, 14day
*/
public class GetReplayDay{
	public static void main(String[] args){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar.getTime());		
		Date date = calendar.getTime();
		GetReplayDay getReplayDay = new GetReplayDay();
		int[] days = {0,1,2,5,8,14};
		for(int i = 0; i < days.length; i++){
			calendar.add(Calendar.DATE,days[i]);
			System.out.println(getReplayDay.formatDate(calendar.getTime()));
		}		
	}
	
	public String formatDate(Date date){
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);	
	}	
}
