/**
 * 
 */
var dataSet = [];
var colormap = ["red", "blue", "yellow", "orange", "green"];
//d3문법
//d3.json('http://localhost:8282/mocom/resources/json/mydata.json', function(err,data) {
d3.json('http://localhost:8282/mocom/selectmember', function(err, data) {
	console.log(data.length);
	for (i = 0; i < data.length; i++) {
		console.log("i = " + i);
		console.log("data[i].age = " + data[i].age);
		dataSet.push(data[i].age * 5)
	}
	d3.select("#myGraph1")
		.selectAll("rect")
		.data(dataSet)
		.enter() //하나하나의 요소를 시작을 해라
		.append("rect") //렉트 추가
		.attr("class", "bar")
		.style("fill", function(d, i) {
			return colormap[i % 3];
		})
		.attr("x", 10)
		//y는 function 값을 받는다. function(d,i) d는 배열의 값 i는 배열의 순서(0,1,2,3...)
		.attr("y", function(d, i) {
			console.log("yd = " + d);
			console.log("yi = " + i);
			return i * 45 + 10;
		})
		//.attr("width", function(d, i) {
		//	console.log("Widthd = " + d);
		//	console.log("Widthi = " + i);
		//	return d;
		//})

		.attr("width", 0)
		.attr("height", 25)

		.transition()
		.duration(1000)
		.delay(function(d, i) { return i * 500; })
		.attr("width", function(d, i) {
			return d;
		})

});


d3.select("#barbtn")
	.on("click", function() {
		d3.selectAll("rect")
			.transition()
			.duration(1000)
			.attr("width", function() {
				return (Math.random() * 300) + 1;
			})
	});

