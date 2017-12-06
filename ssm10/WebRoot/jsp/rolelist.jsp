<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>角色管理页面</span>
       </div>
       <div class="search">
      <%--  <form method="post" action="${pageContext.request.contextPath }/jsp/bill.do">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" type="text" value="${queryProductName }">
			 <input type="hidden" name="pageIndex" value="1"/>
			<span>供应商：</span>
			<select name="queryProviderId">
				<c:if test="${providerList != null }">
				   <option value="0">--请选择--</option>
				   <c:forEach var="provider" items="${providerList}">
				   		<option <c:if test="${provider.id == queryProviderId }">selected="selected"</c:if>
				   		value="${provider.id}">${provider.proName}</option>
				   </c:forEach>
				</c:if>
       		</select>
			 
			<span>是否付款：</span>
			<select name="queryIsPayment">
				<option value="0">--请选择--</option>
				<option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>
				<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option>
       		</select>
			
			 <input	value="查 询" type="submit" id="searchbutton">
			 
		</form> --%>
		<a href="${pageContext.request.contextPath }/jsp/roleadd.jsp">添加角色</a>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">角色编码</th>
              <th width="20%">角色名称</th>
              <!-- <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th> -->
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach var="role" items="${roleList }" varStatus="status">
				<tr>
					<td>
					<span>${role.roleCode }</span>
					</td>
					<td>
					<span>${role.roleName }</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${role.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewRole" href="javascript:;" billid=${role.id } billcc=${role.roleCode }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyRole" href="javascript:;" billid=${role.id } billcc=${role.roleCode }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteRole" href="javascript:;" id=${role.id } name=${role.roleCode }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
      </table>
      <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
  	  <c:import url="rollpage.jsp">
         	<c:param name="totalCount" value="${totalCount}"/>
         	<c:param name="currentPageNo" value="${currentPageNo}"/>
         	<c:param name="totalPageCount" value="${totalPageCount}"/>
       </c:import>
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该角色吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rolelist.js"></script>