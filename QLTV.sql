﻿CREATE DATABASE QLTV14
GO
USE QLTV14
CREATE TABLE TAIKHOAN
(
	TenDangNhap NVARCHAR(10) NOT NULL,
	MatKhau NVARCHAR(10),
	Quyen NVARCHAR(10),
	PRIMARY KEY (TenDangNhap),
)
GO

CREATE TABLE LOAINHANVIEN
(	
	MaLoaiNV NVARCHAR (10) NOT NULL,
	TenLoaiNV NVARCHAR(50),
	PRIMARY KEY (MaLoaiNV),
)
GO

CREATE TABLE NHANVIEN
(
	MaNV NVARCHAR(10) not null,
	SoDienThoai NVARCHAR(11),
	TenDangNhap NVARCHAR(10) NOT NULL,
	HoTen NVARCHAR(50),
	NgaySinh datetime,
	LoaiNV NVARCHAR(10),
	Anh Nvarchar(100),
	PRIMARY KEY (MaNV),
	CONSTRAINT FK_NHANVIEN_DANGNHAPNV FOREIGN KEY (TenDangNhap) REFERENCES TAIKHOAN(TenDangNhap),
	CONSTRAINT FK_NHANVIEN_LOAINHANVIEN FOREIGN KEY (LoaiNV) REFERENCES LOAINHANVIEN(MaLoaiNV)
)
GO

CREATE TABLE TAILIEU
(
	MaTaiLieu Nvarchar(10) NOT NULL,
	TenTaiLieu Nvarchar(50),
	TacGia Nvarchar(50),
	TongSo int,
	ConLai int,
	Gia int,
	Anh Nvarchar(100),
	PRIMARY KEY (MaTaiLieu)
)	
GO

CREATE TABLE DOCGIA
(
	MaDocGia Nvarchar(10) NOT NULL,
	HoTen Nvarchar(50),
	NgaySinh Date,
	DiaChi Nvarchar(50),
	Email Nvarchar(50),
	Sdt Nvarchar(15),
	SoTLDaMuon int,
	PRIMARY KEY (MaDocGia),
)
GO

CREATE TABLE PHIEUMUON
(
	MaPhieuMuon nvarchar(10) not null,
	MaNV nvarchar(10) not null,
	MaDocGia nvarchar(10),
	TinhTrang nvarchar(15),
	NgayLapPhieuMuon Date,
	PRIMARY KEY (MaPhieuMuon),
	CONSTRAINT FK_PHIEUMUON_DOCGIA FOREIGN KEY (MaDocGia) REFERENCES DOCGIA (MaDocGia),
	CONSTRAINT FK_PHIEUMUON_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN (MaNV)
)
GO

CREATE TABLE CHITIETPHIEUMUON	
(
	MaPhieuMuon Nvarchar(10) NOT NULL,
	MaDocGia Nvarchar(10),
	TenDocGia Nvarchar(50),
	MaTaiLieu Nvarchar(10),
	TenTaiLieu Nvarchar(50),
	SoLuongMuon Int,
	NgayMuon Date,
	HanTra Date,
	PRIMARY KEY (MaPhieuMuon),
	CONSTRAINT FK_CHITIETPHIEUMUON_PHIEUMUON FOREIGN KEY (MaPhieuMuon) REFERENCES PHIEUMUON(MaPhieuMuon),
	CONSTRAINT FK_CHITIETPHIEUMUON_TAILIEU FOREIGN KEY (MaTaiLieu) REFERENCES TAILIEU(MaTaiLieu)
)	
GO

CREATE TABLE PHIEUTRA
(
	MaPhieuTra nvarchar(10) not null,
	MaPhieuMuon nvarchar(10) not null,
	MaDocGia nvarchar(10),
	NgayLapPhieuTra Date,
	MaNV nvarchar(10) not null,
	PRIMARY KEY (MaPhieuTra),
	CONSTRAINT FK_PHIEUTRA_PHIEUMUON FOREIGN KEY (MaPhieuMuon) REFERENCES PHIEUMUON(MaPhieuMuon),
	CONSTRAINT FK_PHIEUTRA_DOCGIA FOREIGN KEY (MaDocGia) REFERENCES DOCGIA (MaDocGia),
	CONSTRAINT FK_PHIEUTRA_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN (MaNV)
)
GO

CREATE TABLE CHITIETPHIEUTRA
(
	MaPhieuTra Nvarchar(10) NOT NULL,
	MaPhieuMuon nvarchar(10) not null,
	MaDocGia Nvarchar(10),
	TenDocGia Nvarchar(50),
	MaTaiLieu Nvarchar(10),
	TenTaiLieu Nvarchar(50),
	SoLuongTra Int,
	NgayTra Date,
	PRIMARY KEY (MaPhieuTra),
	CONSTRAINT FK_CHITIETPHIEUTRA_PHIEUTRA FOREIGN KEY (MaPhieuTra) REFERENCES PHIEUTRA(MaPhieuTra)
)
GO

CREATE TABLE PHIEUPHAT
(
	MaPhieuPhat Nvarchar(10) NOT NULL,
	MaPhieuTra Nvarchar(10),
	MaDG Nvarchar(10),
	MaNV nvarchar(10) not null,
	NgayLapPhieu Date 
	PRIMARY KEY (MaPhieuPhat),	
	CONSTRAINT FK_PHIEUPHAT_PHIEUTRA FOREIGN KEY (MaPhieuTra) REFERENCES PHIEUTRA(MaPhieuTra),
	CONSTRAINT FK_PHIEUPHAT_DOCGIA FOREIGN KEY (MaDG) REFERENCES DOCGIA(MaDocGia),
	CONSTRAINT FK_PHIEUPHAT_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN (MaNV)
)
GO
CREATE TABLE LYDOPHAT
(
	MaLyDo Nvarchar(10) NOT NULL,
	LyDo Nvarchar(50),
	SoTienPhat int,
	PRIMARY KEY (MaLyDo),	
)
GO
CREATE TABLE CHITIETPHIEUPHAT
(
	MaPhieuPhat Nvarchar(10) NOT NULL,
	MaPhieuTra Nvarchar(10),
	MaLyDo Nvarchar(10),
	LyDo Nvarchar(50),
	SoLuong int,
	SoTienPhat Int,
	TongTienPhat Int,
	MaDocGia Nvarchar(10),
	TenDocGia Nvarchar(50),
	MaTaiLieu Nvarchar(10),
	TenTaiLieu Nvarchar(50),
	NgayLapPhieu Date 
	PRIMARY KEY (MaPhieuPhat),	
	CONSTRAINT FK_CHITIETPHIEUPHAT_PHIEUPHAT FOREIGN KEY (MaPhieuPhat) REFERENCES PHIEUPHAT(MaPhieuPhat),
	CONSTRAINT FK_CHITIETPHIEUPHAT_LYDOPHAT FOREIGN KEY (MaLyDo) REFERENCES LYDOPHAT(MaLyDo)
)
GO

--Tài khoản
INSERT INTO TAIKHOAN VALUES(N'Admin',N'123456',N'AD');
INSERT INTO TAIKHOAN VALUES(N'Dinh',N'111',N'TT');
INSERT INTO TAIKHOAN VALUES(N'Dat',N'222',N'TT');
SELECT * FROM TAIKHOAN

--Loại nhân viên
INSERT INTO LOAINHANVIEN VALUES(N'AD',N'Quản trị');
INSERT INTO LOAINHANVIEN VALUES(N'TT',N'Thủ thư');
SELECT * FROM LOAINHANVIEN

--Nhân viên
SET DATEFORMAT DMY
INSERT INTO NHANVIEN VALUES(N'NV01','0971881583',N'Admin',N'Nguyễn Thành Đạt','29/01/2002',N'AD',N'..\\QLTV\\src\\img\\thanhdat.png');
INSERT INTO NHANVIEN VALUES(N'NV02','0833243346',N'Dinh',N'Lê Hoài Dinh','28/02/2003',N'TT',N'..\\QLTV\\src\\img\\dinh.png')
INSERT INTO NHANVIEN VALUES(N'NV03','0223243346',N'Dat',N'Võ Thành Đạt','28/02/2003',N'TT',N'..\\QLTV\\src\\img\\dat.png');
SELECT * FROM NHANVIEN

--Tài liệu
INSERT INTO TAILIEU VALUES(N'TL01',N'Công Nghệ JaVa',N'Khoa Công Nghệ Thông Tin',99,20,3860000,N'..\\QLTV\\src\\img\\clean_code.jpg');
INSERT INTO TAILIEU VALUES(N'TL02',N'Hành Trang Lập Trình',N'Vũ Công Tấn Tài',25,10,1790000,N'..\\QLTV\\src\\img\\hanh_trang.jpg');
INSERT INTO TAILIEU VALUES(N'TL03',N'Đắc Nhân Tâm',N'Steven Levy',41,13,2990000,N'..\\QLTV\\src\\img\\hacker.jpg');
INSERT INTO TAILIEU VALUES(N'TL04',N'God Of War',N'Lôi Mễ',72,17,2290000,N'..\\QLTV\\src\\img\\ghost.jpg');
INSERT INTO TAILIEU VALUES(N'TL05',N'Phân Tích Thiết Kế Hệ Thống Thống Thông Tin',N'Khoa Công Nghệ Thông Tin',10,3,210000,N'..\\QLTV\\src\\img\\de_thi.jpg');
INSERT INTO TAILIEU VALUES(N'TL06',N'Lập Trình Mã Nguồn Mở',N'Khoa Công Nghệ Thông Tin',25,13,2880000,N'..\\QLTV\\src\\img\\tam_ly.jpg');
INSERT INTO TAILIEU VALUES(N'TL07',N'Thực Hành Hướng Đối Tượng',N'Khoa Công Nghệ Thông Tin',19,11,1890000,N'..\\QLTV\\src\\img\\tam_than.jpg');
INSERT INTO TAILIEU VALUES(N'TL08',N'Thiên Tài Bên Trái, Kẻ Điên Bên Phải',N'Cao Minh',33,11,1790000,N'..\\QLTV\\src\\img\\thien_tai.jpg');
INSERT INTO TAILIEU VALUES(N'TL09',N'Giáo Dục Quốc Phòng 1',N'Quốc Phòng và Thể Chất',35,22,16000,N'..\\QLTV\\src\\img\\soi.jpg');
INSERT INTO TAILIEU VALUES(N'TL10',N'Vua Sư Tử',N'Same Kaean',36,13,259000,N'..\\QLTV\\src\\img\\tam_tri.jpg');
SELECT * FROM TAILIEU

--Độc giả
SET DATEFORMAT DMY
INSERT INTO DOCGIA VALUES(N'DG01',N'Nguyễn Thị Minh Thư','28/02/2002',N'Bến Tre',N'minhthu@gmail.com',N'0987654321',0);
INSERT INTO DOCGIA VALUES(N'DG02',N'Nguyễn Minh Chiến','23/04/2002',N'Long An',N'minhchien@gmail.com',N'0902394835',0);
INSERT INTO DOCGIA VALUES(N'DG03',N'Nguyễn Đức Khang','11/02/2002',N'Đồng Nai',N'duckhang@gmail.com',N'0903724835',0);
INSERT INTO DOCGIA VALUES(N'DG04',N'Trần Thị Trang Anh','29/03/2003',N'Tp.HCM',N'tranganh@gmail.com',N'0328429375',0);
INSERT INTO DOCGIA VALUES(N'DG05',N'Đỗ Tấn Đạt','28/02/2002',N'TPHCM',N'dat@gmail.com',N'0324868493',0);
INSERT INTO DOCGIA VALUES(N'DG06',N'Lê Trần Duy Tân','28/07/2002',N'TPHCM',N'duytan@gmail.com',N'0903857483',0);
INSERT INTO DOCGIA VALUES(N'DG07',N'Nguyễn Hoàng Phú','18/02/2002',N'Long An',N'mphu@gmail.com',N'0703958476',0);
INSERT INTO DOCGIA VALUES(N'DG08',N'Nguyễn Thanh Hải','28/03/2002',N'TPHCM',N'hai@gmail.com',N'0704935786',0);
INSERT INTO DOCGIA VALUES(N'DG09',N'Nguyễn Thành Long','11/09/2001',N'TPHCM',N'long@gmail.com',N'0328467395',0);
INSERT INTO DOCGIA VALUES(N'DG10',N'Nguyễn Văn Vinh','28/11/2002',N'Bình Thuận',N'vinh@gmail.com',N'0903284954',0);
SELECT * FROM DOCGIA

--Phiếu mượn
SET DATEFORMAT DMY
INSERT INTO PHIEUMUON VALUES(N'PM01',N'NV01',N'DG06',N'Đang Mượn','03/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM02',N'NV02',N'DG01',N'Đang Mượn','03/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM03',N'NV03',N'DG07',N'Đang Mượn','03/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM04',N'NV04',N'DG04',N'Đang Mượn','10/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM05',N'NV03',N'DG10',N'Đang Mượn','10/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM06',N'NV04',N'DG03',N'Đang Mượn','13/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM07',N'NV02',N'DG09',N'Đang Mượn','13/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM08',N'NV03',N'DG05',N'Đang Mượn','13/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM09',N'NV02',N'DG02',N'Đang Mượn','23/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM10',N'NV04',N'DG08',N'Đang Mượn','23/01/2023');
INSERT INTO PHIEUMUON VALUES(N'PM11',N'NV02',N'DG03',N'Đang Mượn','23/04/2023');
SELECT * FROM PHIEUMUON

--CHI TIẾT PHIẾU MƯỢN
SET DATEFORMAT DMY
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM01',N'DG06',N'Lê Trần Duy Tân',N'TL09',N'Giáo Dục Quốc Phòng 1',2,'03/01/2023','10/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM02',N'DG01',N'Nguyễn Thị Minh Thư',N'TL10',N'Vua Sư Tử',3,'03/01/2023','10/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM03',N'DG07',N'Nguyễn Hoàng Phú',N'TL01',N'Công Nghệ JaVa',1,'03/01/2023','10/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM04',N'DG04',N'Trần Thị Trang Anh',N'TL07',N'Thực Hành Hướng Đối Tượng',3,'10/01/2023','17/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM05',N'DG10',N'Nguyễn Văn Vinh',N'TL03',N'Đắc Nhân Tâm',2,'10/01/2023','17/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM06',N'DG03',N'Nguyễn Đức Khang',N'TL02',N'Hành Trang Lập Trình',1,'13/01/2023','20/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM07',N'DG09',N'Nguyễn Thành Long',N'TL06',N'Lập Trình Mã Nguồn Mở',1,'13/01/2023','20/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM08',N'DG05',N'Đỗ Tấn Đạt',N'TL05',N'Phân Tích Thiết Kế Hệ Thống Thống Thông Tin',3,'13/01/2023','20/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM09',N'DG02',N'Nguyễn Minh Chiến',N'TL09',N'Giáo Dục Quốc Phòng 1',1,'23/01/2023','30/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM10',N'DG08',N'Nguyễn Thanh Hải',N'TL04',N'God Of War',2,'23/01/2023','30/01/2023');
INSERT INTO CHITIETPHIEUMUON VALUES(N'PM11',N'DG03',N'Nguyễn Đức Khang',N'TL04',N'God Of War',2,'23/04/2023','30/04/2023');
SELECT * FROM CHITIETPHIEUMUON

--PHIẾU TRẢ
SET DATEFORMAT DMY
INSERT INTO PHIEUTRA VALUES(N'PT01',N'PM01',N'DG06','12/01/2023',N'NV01');
INSERT INTO PHIEUTRA VALUES(N'PT02',N'PM02',N'DG01','14/01/2023',N'NV02');
INSERT INTO PHIEUTRA VALUES(N'PT03',N'PM03',N'DG07','13/01/2023',N'NV03');
INSERT INTO PHIEUTRA VALUES(N'PT04',N'PM04',N'DG04','15/01/2023',N'NV04');
INSERT INTO PHIEUTRA VALUES(N'PT05',N'PM05',N'DG10','13/01/2023',N'NV02');
INSERT INTO PHIEUTRA VALUES(N'PT06',N'PM06',N'DG03','18/01/2023',N'NV03');
INSERT INTO PHIEUTRA VALUES(N'PT07',N'PM07',N'DG09','16/01/2023',N'NV04');
INSERT INTO PHIEUTRA VALUES(N'PT08',N'PM08',N'DG05','15/01/2023',N'NV03');
INSERT INTO PHIEUTRA VALUES(N'PT09',N'PM09',N'DG02','29/01/2023',N'NV04');
INSERT INTO PHIEUTRA VALUES(N'PT10',N'PM10',N'DG08','30/01/2023',N'NV01');
SELECT * FROM PHIEUTRA

--CHI TIẾT PHIẾU TRẢ
SET DATEFORMAT DMY
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT01',N'PM01',N'DG06',N'Lê Trần Duy Tân',N'TL09',N'Giáo Dục Quốc Phòng 1',2,'12/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT02',N'PM02',N'DG01',N'Nguyễn Thị Minh Thư',N'TL10',N'Vua Sư Tử',3,'14/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT03',N'PM03',N'DG07',N'Nguyễn Hoàng Phú',N'TL01',N'Công Nghệ JaVa',1,'13/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT04',N'PM04',N'DG04',N'Trần Thị Trang Anh',N'TL07',N'Thực Hành Hướng Đối Tượng',3,'15/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT05',N'PM05',N'DG10',N'Nguyễn Văn Vinh',N'TL03',N'Đắc Nhân Tâm',2,'13/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT06',N'PM06',N'DG03',N'Nguyễn Đức Khang',N'TL02',N'Hành Trang Lập Trình',1,'18/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT07',N'PM07',N'DG09',N'Nguyễn Thành Long',N'TL06',N'Lập Trình Mã Nguồn Mở',1,'16/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT08',N'PM08',N'DG05',N'Đỗ Tấn Đạt',N'TL05',N'Phân Tích Thiết Kế Hệ Thống Thống Thông Tin',3,'15/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT09',N'PM09',N'DG02',N'Nguyễn Minh Chiến',N'TL09',N'Giáo Dục Quốc Phòng 1',1,'29/01/2023');
INSERT INTO CHITIETPHIEUTRA VALUES(N'PT10',N'PM10',N'DG08',N'Nguyễn Thanh Hải',N'TL04',N'God Of War',2,'30/01/2023');
SELECT * FROM CHITIETPHIEUTRA

--PHIẾU PHẠT
SET DATEFORMAT DMY
INSERT INTO PHIEUPHAT VALUES(N'PP01',N'PT01',N'DG06',N'NV01','12/01/2023');
INSERT INTO PHIEUPHAT VALUES(N'PP02',N'PT03',N'DG07',N'NV03','13/01/2023');
INSERT INTO PHIEUPHAT VALUES(N'PP03',N'PT05',N'DG10',N'NV02','13/01/2023');
INSERT INTO PHIEUPHAT VALUES(N'PP04',N'PT02',N'DG01',N'NV02','14/01/2023');
INSERT INTO PHIEUPHAT VALUES(N'PP05',N'PT08',N'DG05',N'NV03','15/01/2023');
SELECT * FROM PHIEUPHAT
--CHI TIẾT Lý Do Phạt
insert into LYDOPHAT values (N'LD01',N'QUÁ HẠN',20000);
insert into LYDOPHAT values (N'LD02',N'HƯ HỎNG',100000);
insert into LYDOPHAT values (N'LD03',N'LÀM BẨN',50000);
SELECT * FROM LYDOPHAT
--CHI TIẾT PHIẾU PHẠT
INSERT INTO CHITIETPHIEUPHAT VALUES(N'PP01',N'PT01',N'LD01',N'QUÁ HẠN',2,20000,40000,N'DG06',N'Trần Thị Trang Anh',N'TL09',N'Giáo Dục Quốc Phòng 1','12/01/2023');
INSERT INTO CHITIETPHIEUPHAT VALUES(N'PP02',N'PT03',N'LD02',N'HƯ HỎNG',3,100000,300000,N'DG07',N'Nguyễn Hoàng Phú',N'TL01',N'Công Nghệ JaVa','13/01/2023');
INSERT INTO CHITIETPHIEUPHAT VALUES(N'PP03',N'PT05',N'LD03',N'LÀM BẨN',1,50000,50000,N'DG10',N'Nguyễn Văn Vinh',N'TL03',N'Đắc Nhân Tâm','13/01/2023');
INSERT INTO CHITIETPHIEUPHAT VALUES(N'PP04',N'PT02',N'LD01',N'QUÁ HẠN',4,20000,80000,N'DG01',N'Nguyễn Thị Minh Thư',N'TL10',N'Vua Sư Tử','14/01/2023');
INSERT INTO CHITIETPHIEUPHAT VALUES(N'PP05',N'PT08',N'LD03',N'LÀM BẨN',1,50000,50000,N'DG05',N'Đỗ Tấn Đạt',N'TL05',N'Phân Tích Thiết Kế Hệ Thống Thống Thông Tin','15/01/2023');
SELECT * FROM CHITIETPHIEUPHAT


