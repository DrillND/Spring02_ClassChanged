/**
 * 
 */
/*var dataSet = [100, 10, 120, 200, 90];*/
var dataSet = [];
/*앞에 파일에 에러가 있으면 에러로 아니면 데이터로 들어감 csv가*/
d3.csv('http://localhost:8282/mocom/resources/csv/mydata.csv', function(err, data) {
	
	for(i=0; i<160; i=i+20){
		console.log("i = "+i);
		console.log("data[i].weight = "+data[i].Weight)
	}
	
	d3.selectAll("rect")
		.data(dataSet)
		.enter()
		.append("rect")
		.attr("class", "bar")
		.attr("x", 10)
		.attr("y", function(d, i) {
			return i * 45 + 10;
		})
		.attr("width", function(ele, i) { return ele; })
		.attr("height", 30)

});

d3.select("#barBtn")
	.on("click", function() {
		d3.selectAll("rect")
			.transition()
			.duration(1000)
			.attr("width", function() {
				return (Math.random() * 300) + 1;
			})
	});