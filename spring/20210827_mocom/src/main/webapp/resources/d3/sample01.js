var dataSet =  [100,10,120,200,90];

d3.select("#myGraph")
  .selectAll("rect")
  .data(dataSet)
  .enter()
  /*엔터 뒤에 것들 하나하나 100 돌리고 10돌리고*/
  .append("rect")
  .attr("class","bar")
  .attr("width",function(d,i){
      return d;
  })
  .attr("height",40)
  .attr("x",0)
  .attr("y",function(d,i){
      return i*45;
  })