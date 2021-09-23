/**
 * 
 */
var dataSet = [];

d3.csv('http://localhost:8282/mocom/resources/csv/mydata.csv', function(err,data) {
	console.log(data.length);
	for (i = 0; i < data.length; i = i + 20) {
		console.log("i = " + i);
		console.log("data[i].Weight = " + data[i].Weight);
		dataSet.push(data[i].Weight / 4)
	}
	d3.select("#myGraph1")
		.selectAll("rect")
		.data(dataSet)
		.enter() //하나하나의 요소를 시작을 해라
		.append("rect") //렉트 추가
		.attr("class", "bar")
		.attr("x", 10)
		.attr("y", function(d, i) {
			console.log("yd = "+d);
			console.log("yd = "+i);
			return i * 45 + 10;
		})
		.attr("width", function(d, i) { 
			console.log("Widthd = "+d);
			console.log("Widthi = "+i);
			return d; 
			})
		.attr("height", 30)
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

