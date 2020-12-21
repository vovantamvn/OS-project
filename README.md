# Đề tài số 11. Tìm hiểu các lời gọi hệ thống (System calls).
## Yêu cầu
1. Tìm hiểu các lời gọi hệ thống trong quản lý tiến trình.
2. Tìm hiểu các lời gọi hệ thống trong quản lý file, thư mục.
3. Trình bày các lời gọi hệ thống trong Win32 API hoặc Linux.
4. Xây dựng chương trình với các chức năng: Tạo File, Xoá File, Copy;
Tạo thư mục, xoá thư mục, đổi tên.
5. Viết báo cáo theo mẫu Bộ môn mạng và Truyền thông
6. Gặp giáo viên hướng dẫn, làm đúng yêu cầu của giáo viên hướng dẫn
và báo cáo tiến độ đúng thời gian
7. Làm 10 đến 15 slide để bảo vệ sau khi được giáo viên hướng dẫn
duyệt và đồng ý được bảo vệ.

## Cách cấu hình

### Thêm thư viện JavaFx
1. Vào **File | Project Structure**
2. Vào **Libraries**
3. Chọn dấu **+** và chọn **Java**
4. Trỏ tới thư mục **lib** của **project**

### Thêm VM options
1. Vào **Run | Edit Configurations**
2. Chọn **Main** ở phía bên trái
3. Trong thuộc tính VM options, thêm vào: --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml
---module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml
4. Thay %PATH_TO_FX% thành địa chỉ đến thư mục **lib** trong **project**

Ví dụ:
>
>--module-path /home/vovantam/IdeaProjects/OS-project/lib --add-modules javafx.controls,javafx.fxml
>
Chi tiết xem [tại đây](https://www.jetbrains.com/help/idea/javafx.html#vm-options)
## Nhóm
- Võ Văn Tâm
- Hoàng Minh Lộc
