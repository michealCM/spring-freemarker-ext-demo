<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:forward page="index.html"/>

         <@includex template="common/common_111" default_template="common/common">
         <@includex template="${template}" default_template="common/common">
         <@cache template="common/common" time=60/>
         
         
         
