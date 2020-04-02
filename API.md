#接口说明
##get post均可
101.132.158.185:8082/

获取首页数据  街道信息：
 路由：/index
 参数：无
 ```json
 {
 	"code": 200,
 	"data": [{
 		"cityId": 1,
 		"createDate": 1585216856000,
 		"garbageSum": 1990.24,
 		"harmfulWaster": 497.79,
 		"kitchenWaster": 964.40,
 		"lat": 45.782051,
 		"lng": 126.643806,
 		"otherWaster": 170.46,
 		"recyclable": 357.60,
 		"recycleSum": 1428.73,
 		"streetId": 60,
 		"streetName": "靖宇街道"
 	}, {
 		"cityId": 1,
 		"createDate": 1585216856000,
 		"garbageSum": 1375.00,
 		"harmfulWaster": 572.53,
 		"kitchenWaster": 495.84,
 		"lat": 45.75597,
 		"lng": 126.6521,
 		"otherWaster": 122.49,
 		"recyclable": 184.15,
 		"recycleSum": 936.17,
 		"streetId": 61,
 		"streetName": "和兴路街道"
 	}, {
 		"cityId": 1,
 		"createDate": 1585216856000,
 		"garbageSum": 2477.38,
 		"harmfulWaster": 987.35,
 		"kitchenWaster": 335.51,
 		"lat": 45.704582,
 		"lng": 126.609962,
 		"otherWaster": 845.76,
 		"recyclable": 308.77,
 		"recycleSum": 1964.19,
 		"streetId": 62,
 		"streetName": "哈西街道"
 	}, {
 		"cityId": 1,
 		"createDate": 1585216856000,
 		"garbageSum": 2487.90,
 		"harmfulWaster": 348.39,
 		"kitchenWaster": 963.71,
 		"lat": 45.751106,
 		"lng": 126.646629,
 		"otherWaster": 587.60,
 		"recyclable": 588.20,
 		"recycleSum": 1508.71,
 		"streetId": 63,
 		"streetName": "花园街道"
 	}],
 	"message": "返回成功"
 }
```
饼状图 街道： 

getPieChartStreet

(String city, String street)
```json


{
	"code": 200,
	"data": {
		"harmfulWaster": 0.5370,
		"kitchenWaster": 0.2566,
		"name": "和兴路",
		"otherWaster": 0.1682,
		"recyclable": 0.0382
	},
	"message": "返回成功"
}
```
饼状图 市区：

 路由：getPieChartCity
 
 参数：(String city)
 ```json

 {
	"code": 200,
	"data": {
		"harmfulWaster": 0.1873,
		"kitchenWaster": 0.3576,
		"name": "哈尔滨市",
		"otherWaster": 0.0647,
		"recyclable": 0.3904
	},
	"message": "返回成功"
}

```
最近30天的数据（全国）：

getCurrent30Days

无参数
 ```json
  {
 	"code": 200,
 	"data": {
 		"2020-03-11": 26265.00,
 		"2020-03-10": 12104.00,
 		"2020-03-13": 29699.00,
 		"2020-04-02": 20858.29,
 		"2020-03-12": 12802.00,
 		"2020-03-15": 18457.00,
 		"2020-03-14": 35485.00,
 		"2020-03-17": 16931.00,
 		"2020-03-16": 15166.00,
 		"2020-03-08": 31367.00,
 		"2020-03-07": 21455.00,
 		"2020-03-09": 25166.00,
 		"2020-03-22": 26370.00,
 		"2020-03-21": 19413.00,
 		"2020-03-24": 29745.09,
 		"2020-03-02": 5827.00,
 		"2020-03-23": 11095.57,
 		"2020-03-01": 6351.00,
 		"2020-03-26": 31494.27,
 		"2020-03-04": 28306.00,
 		"2020-03-25": 18024.90,
 		"2020-03-03": 27020.00,
 		"2020-03-06": 29965.00,
 		"2020-03-05": 12611.00,
 		"2020-03-20": 19396.00,
 		"2020-03-19": 20967.00,
 		"2020-03-18": 14414.00
 	},
 	"message": "返回成功"
 }

```


城市垃圾排名 top3：

getCityRank

无参数
 ```json
 {
	"code": 200,
	"data": [{
		"carbageSum": 2373.63,
		"completionRate": 0.9785,
		"name": "北京市",
		"num": 1
	}, {
		"carbageSum": 1892.57,
		"completionRate": 0.5242,
		"name": "上海市",
		"num": 2
	}, {
		"carbageSum": 775.73,
		"completionRate": 0.9616,
		"name": "哈尔滨市",
		"num": 3
	}],
	"message": "返回成功"
}

```
街道垃圾排名 top3：

getStreetRank

无参数
 ```json
 {
	"code": 200,
	"data": [{
		"carbageSum": 1826.65,
		"completionRate": 0.1680,
		"name": "和兴路",
		"num": 1
	}, {
		"carbageSum": 1821.40,
		"completionRate": 0.5422,
		"name": "和平路",
		"num": 2
	}, {
		"carbageSum": 914.87,
		"completionRate": 0.9342,
		"name": "中央大街",
		"num": 3
	}],
	"message": "返回成功"
}
```
市级最近七天数据： 

getCurrentCity7Days

(String city)
```json

 {
	"code": 200,
	"data": {
		"2020-04-02": 1669.58,
		"2020-03-26": 775.73
	},
	"message": "返回成功"
}
```
