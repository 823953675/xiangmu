<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"></security:authentication></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="#"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li id="system-setting">
						<security:authorize access="hasRole('ADMIN')">
						<a
						href="${pageContext.request.contextPath}/user/findAll.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a>
						</security:authorize>
					</li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAllRole.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>

					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/pages/upload.jsp"> <i
							class="fa fa-circle-o"></i> 图片上传
					</a></li>


				</ul>

			</li>


		</ul>
	</section>
	<!-- /.sidebar -->
</aside>