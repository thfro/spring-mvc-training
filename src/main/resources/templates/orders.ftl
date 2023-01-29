<html>
<head>

    <title> FreeMarker Order List</title>

    <style>
        body, input {
            font-family: Calibri, Arial;
            margin: 0px;
            padding: 0px;
        }
        #header h2 {
            color: white;
            background-color: #3275A8;
            height: 50px;
            padding: 5px 0 0 5px;
            font-size: 20px;
        }

        .datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:600px;max-width:100%;font-family:Calibri}
        .datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
        .datatable tr {border:1px solid #888}
        .datatable tr.odd {background-color:#eee}
        .datatable td {padding:2px;border:1px solid #888}
        #content { padding 5px; margin: 5px; text-align: center}
        fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
        legend { font-weight: bold; }
    </style>

<body>
<div id="header">
    <h2>Order List</h2>
</div>

<div id="content">
    <table class="datatable">
        <tr>
            <th>Order ID</th>  <th>Customer</th>
        </tr>
        <#list model["orderList"] as order>
            <tr>
                <td>${order.id}</td> <td><b>Email:</b> ${order.customer.email} <br/> <b>Mobile:</b> ${order.customer.mobile}</td>
            </tr>
        </#list>
    </table>

    ${msg}
</div>
</body>
</html>