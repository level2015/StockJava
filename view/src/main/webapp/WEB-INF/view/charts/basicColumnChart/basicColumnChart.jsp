<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<div id="tab">
  <div id="tabhead">
    <ul>
      <li><a href="/diagram/about">About charts</a></li>
      <li><a href="/diagram/pieChart">Pie chart</a></li>
      <li class="activetab"><a href="/diagram/basicColumnChart">Basic column chart</a></li>
      <li><a href="#">Chart2</a></li>
      <li><a href="#">Chart3</a></li>
    </ul>
  </div>
  <div id="tabcontent">
    <h3>Круговая диаграмма</h3>
    <input id="showButtonBC" type="button" value="Show chart!">
    <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
  </div>
</div>

