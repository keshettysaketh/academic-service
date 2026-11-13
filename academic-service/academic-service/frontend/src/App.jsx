import { useEffect, useMemo, useState } from "react";
import { BrowserRouter, NavLink, Navigate, Route, Routes, useLocation } from "react-router-dom";
import { Activity, Award, Bell, BookOpen, CalendarDays, CalendarCheck2, Check, ChevronRight, Clock3, ClipboardList, GraduationCap, LayoutDashboard, LogOut, Menu, Search, Settings2, UserRound, X } from "lucide-react";
import academicService from "./services/academicService";
import { ResourcePage, resources } from "./components/ResourcePage";
import Dashboard from "./pages/Dashboard";
import "./App.css";

const nav = [
  ["Dashboard", "/", LayoutDashboard], ["Courses", "/courses", BookOpen],
  ["Attendance", "/attendance", CalendarCheck2], ["Timetable", "/timetable", Clock3],
  ["Assignments", "/assignments", ClipboardList], ["Examinations", "/examinations", FileIcon],
  ["Results", "/results", Award],
];
function FileIcon(props) { return <CalendarDays {...props} />; }

function Login({ onLogin }) {
  const [id, setId] = useState(localStorage.getItem("studentId") || "101");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  return <main className="login-screen"><section className="login-art"><div className="login-art-top"><div className="brand-mark"><GraduationCap /></div><span>SMARTCAMPUS</span></div><div className="art-copy"><span className="eyebrow">YOUR CAMPUS, IN SYNC</span><h1>Make room for<br/><em>what’s next.</em></h1><p>One clear view of your courses, classes and progress.</p></div><div className="art-note"><span className="live-dot"/>Your semester, at a glance</div><div className="art-orbit orbit-one"/><div className="art-orbit orbit-two"/></section><section className="login-panel"><div className="login-form-wrap"><div className="mobile-brand"><GraduationCap/> SmartCampus</div><span className="eyebrow">STUDENT PORTAL</span><h2>Welcome back</h2><p className="muted">Sign in to continue to your dashboard.</p><form onSubmit={e=>{e.preventDefault();onLogin(id);}}><label htmlFor="student-id">Student ID</label><input id="student-id" value={id} onChange={e=>setId(e.target.value)} placeholder="e.g. 101" required/><div className="label-row"><label htmlFor="password">Password</label><span className="form-hint">Use any password</span></div><div className="password-input"><input id="password" type={showPassword?"text":"password"} value={password} onChange={e=>setPassword(e.target.value)} placeholder="Enter your password" required/><button type="button" className="text-button" onClick={()=>setShowPassword(v=>!v)}>{showPassword?"Hide":"Show"}</button></div><button className="button button-primary login-submit">Sign in <ChevronRight size={17}/></button></form><p className="login-help">Demo portal · Student ID is used to load your academic records.</p></div><footer className="login-footer">© 2026 SmartCampus <span>Built for better learning</span></footer></section></main>;
}

function Portal({ studentId, onLogout }) {
  const [mobileNav, setMobileNav] = useState(false);
  const [notice, setNotice] = useState(false);
  const location=useLocation();
  const title=nav.find(item=>item[1]===location.pathname)?.[0]||"Dashboard";
  useEffect(()=>setMobileNav(false),[location.pathname]);
  return <div className="app-layout"><aside className={`sidebar ${mobileNav?"sidebar-open":""}`}><div className="brand"><div className="brand-mark"><GraduationCap/></div><div><strong>SmartCampus</strong><small>STUDENT PORTAL</small></div><button className="mobile-close icon-button" onClick={()=>setMobileNav(false)} aria-label="Close menu"><X/></button></div><div className="nav-caption">MENU</div><nav className="side-nav">{nav.map(([name,path,Icon])=><NavLink key={path} to={path} end={path==="/"} className={({isActive})=>`nav-item ${isActive?"active":""}`}><Icon size={18}/><span>{name}</span>{name==="Assignments"&&<span className="nav-count">3</span>}</NavLink>)}</nav><div className="sidebar-bottom"><div className="semester-card"><div className="semester-icon"><Activity size={17}/></div><div><small>CURRENT TERM</small><strong>Fall semester <span>2026</span></strong></div></div><button className="nav-item profile-link" onClick={()=>setNotice(true)}><Settings2 size={18}/><span>Preferences</span></button><button className="nav-item logout-button" onClick={onLogout}><LogOut size={18}/><span>Sign out</span></button><div className="sidebar-user"><div className="avatar">{String(studentId).slice(-2)}</div><div className="user-copy"><strong>Student {studentId}</strong><small>Undergraduate</small></div><ChevronRight size={15} className="user-chevron"/></div></div></aside>{mobileNav&&<button className="nav-scrim" onClick={()=>setMobileNav(false)} aria-label="Close navigation"/>}<main className="main-area"><header className="topbar"><div className="topbar-heading"><button className="mobile-menu icon-button" onClick={()=>setMobileNav(true)} aria-label="Open menu"><Menu/></button><div><span className="breadcrumb">Student portal <ChevronRight size={12}/> {title}</span><h1>{title}</h1></div></div><div className="topbar-actions"><button className={`icon-button notification-button ${notice?"notified":""}`} aria-label="Notifications" onClick={()=>setNotice(v=>!v)}><Bell size={18}/><i/></button><div className="topbar-divider"/><div className="topbar-user"><div className="avatar">{String(studentId).slice(-2)}</div><div><strong>Student {studentId}</strong><small>My account</small></div></div></div></header>{notice&&<div className="notice-popover"><button className="icon-button" onClick={()=>setNotice(false)} aria-label="Close"><X size={16}/></button><strong>You’re all caught up</strong><span>New campus updates will show up here.</span></div>}<div className="route-content"><Routes><Route path="/" element={<Dashboard studentId={studentId}/>} />{Object.entries(resources).map(([key,config])=><Route key={key} path={config.path} element={<ResourcePage resourceKey={key} studentId={studentId}/>} />)}<Route path="*" element={<Navigate to="/" replace/>}/></Routes></div></main></div>;
}

export default function App(){
  const [studentId,setStudentId]=useState(localStorage.getItem("studentId"));
  const onLogin=id=>{localStorage.setItem("studentId",id);setStudentId(id);};
  const onLogout=()=>{localStorage.removeItem("studentId");setStudentId(null);};
  return <BrowserRouter>{studentId?<Portal studentId={studentId} onLogout={onLogout}/>:<Login onLogin={onLogin}/>}</BrowserRouter>;
}
