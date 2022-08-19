<%-- 
    Document   : DemoScreen
    Created on : Aug 18, 2022, 10:58:49 PM
    Author     : ducmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <table border = "1px">
            <tr><center style="color:red;font-size:40px;">Bảng chấm công tháng 8/22</center></tr>
            <tr>
                <td rowspan="2">STT</td>
                <td rowspan="2">Tên</td>
                <td rowspan="2">Chức vụ</td>
                <td colspan="31"><center style="font-size:30px;">Các ngày trong tháng</center></td>
                <td rowspan="2">Tổng công</td>
                <td rowspan="2">Ngày đi làm</td>
                <td rowspan="2">Nghỉ không phép</td>
                <td rowspan="2">Nghỉ có phép</td>
                <td rowspan="2"> Luong </td>
            </tr>
            <tr>            
                <td>1</td>
                <td>2</td>
                <td>3</td> 
                <td>4</td>
                <td>5</td>
                <td>6</td>
                <td style="background-color: yellow">7</td> 
                <td>8</td>
                <td>9</td>
                <td>10</td>
                <td>11</td> 
                <td>12</td>
                <td>13</td>
                <td style="background-color: yellow">14</td>
                <td>15</td> 
                <td>16</td>
                <td>17</td>
                <td>18</td>
                <td>19</td> 
                <td>20</td>
                <td style="background-color: yellow">21</td>
                <td>22</td>
                <td>23</td> 
                <td>24</td>
                <td>25</td>
                <td>26</td>
                <td>27</td> 
                <td style="background-color: yellow">28</td>
                <td>29</td>
                <td>30</td>
                <td>31</td> 
            </tr>
            <tr>
                <td>1</td>
                <td><a href = "#">MrA</a></td>
                <td>Nhân viên</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td style="background-color: yellow">CN</td> 
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td style="background-color: yellow">CN</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td style="background-color: yellow">CN</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td style="background-color: yellow">CN</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>30</td>
                <td>30</td>
                <td>0</td>
                <td>0</td>
                <td>500</td>
            </tr>
            <tr>
                <td>2</td>
                <td><a href = "#">MrB</a></td>
                <td>Truong phòng</td>
                <td>x</td>
                 <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td style="background-color: yellow">CN</td> 
                <td>v</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td style="background-color: yellow">CN</td>
                <td>v</td> 
                <td>v</td>
                <td>x</td>
                <td>x</td>
                <td>v</td> 
                <td>x</td>
                <td style="background-color: yellow">CN</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>v</td>
                <td>v</td> 
                <td style="background-color: yellow">CN</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>30</td>
                <td>25</td>
                <td>0</td>
                <td>5</td>
                <td>1200 </td>
            </tr>
            <tr>
                <td>3</td>
                <td><a href = "#">MrC</a></td>
                <td>Nhân viên</td>>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td>v</td>
                <td>x</td>
                <td>x</td>
                <td style="background-color: yellow">CN</td> 
                <td>x</td>
                <td>KP</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td style="background-color: yellow">CN</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>v</td>
                <td>v</td> 
                <td>x</td>
                <td style="background-color: yellow">CN</td>
                <td>x</td>
                <td>x</td> 
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td>x</td> 
                <td style="background-color: yellow">CN</td>
                <td>x</td>
                <td>v</td>
                <td>x</td> 
                <td>29</td>
                <td>25</td>
                <td>1</td>
                <td>4</td>
                <td>400</td>
            </tr>
            
            <table border="1px">
                <tr style="font-size:15px;"> 
                    <td >
                        Ghi chú: 
                        - Ốm: Ô	
                        -- Nghỉ không phép: KP
                        -- Thai sản:TS	
                        -- Nghỉ phép: V
                        -- Chủ nhật: CN
                    </td>
                </tr>
            </table>

</table>
    </body>
</html>
