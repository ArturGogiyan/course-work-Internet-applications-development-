<td class="result">
        <%int i=0;
    HttpSession httpSession = request.getSession();
        String valR = "valueR";
        String valX = "valueX";
        String valY = "valueY";
        String valRes = "results";
    while (httpSession.getAttribute(valR+i)!=null)i++;
    %>
    <p><b>Current results:</b>
    <p>X:  <%=request.getSession().getAttribute(valX+(0))%>
    <p>Y:  <%=request.getSession().getAttribute(valY+(0))%>
    <p>R:  <%=request.getSession().getAttribute(valR+(0))%>
    <p><b>Result:  <%=request.getSession().getAttribute(valRes+(0))%></b>
    <p>
            <%
        if(i!=1){%>
    <p><b>Previous results:</b>
            <%for(int j=1;j<i;j++){
        %>
    <p><%=j+1%>:
    <p>X:  <%=request.getSession().getAttribute(valX+j)%>
    <p>Y:  <%=request.getSession().getAttribute(valY+j)%>
    <p>R:  <%=request.getSession().getAttribute(valR+j)%>
    <p><b>Result:  <%=request.getSession().getAttribute(valRes+j)%></b>
            <%}}%>
<td>

