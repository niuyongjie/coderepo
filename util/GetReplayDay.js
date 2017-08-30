//增加指定天数
function addDate(date, day) {
	var baseDate = date.valueOf();
	//对基数时间增加指定天数
	baseDate -= day * 24 * 60 * 60 * 1000;
	return dateFormat(new Date(baseDate));
}

//格式化时间
function dateFormat(date) {
	var dateStr = date.getFullYear() + '-';

	if ((date.getMonth() + 1) < 10) {
		//月份小于10补零
		dateStr += '0' + (date.getMonth() + 1);
	} else {
		dateStr += date.getMonth() + 1;
	}

	if (date.getDate() < 10) {
		//天数小于10补零
		dateStr += '-' + '0' + date.getDate();
	} else {
		dateStr += '-' + date.getDate();
	}

	return dateStr;
}

//时间间隔天数
var items = [0, 1, 2, 5, 8, 14];

//循环输出时间间隔
for (var i = 0; i < items.length; i++) {
	console.log(addDate(new Date(), items[i]))
}

