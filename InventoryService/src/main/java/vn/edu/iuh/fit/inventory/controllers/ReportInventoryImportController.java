package vn.edu.iuh.fit.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.inventory.services.ReportInventoryImportService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/report-import")
public class ReportInventoryImportController {
    @Autowired
    private ReportInventoryImportService reportInventoryImportService;

    // Lấy số lượng phiếu nhập kho trong các tuần
    @RequestMapping("/count-week")
    public List<Object[]> countInventoryImportThisWeek() {
        return reportInventoryImportService.countInventoryImportThisWeek();
    }

    // Lấy số lượng phiếu nhập kho trong các tháng
    @RequestMapping("/count-month")
    public List<Object[]> countInventoryImportThisMonth() {
        return reportInventoryImportService.countInventoryImportThisMonth();
    }

    // Lấy số lượng phiếu nhập kho trong các năm
    @RequestMapping("/count-year")
    public List<Object[]> countInventoryImportThisYear() {
        return reportInventoryImportService.countInventoryImportThisYear();
    }

    // Lấy số lượng phiếu nhập kho bị huỷ trong các tuần
    @RequestMapping("/count-cancelled-week")
    public List<Object[]> countCancelledByWeek() {
        return reportInventoryImportService.countCancelledByWeek();
    }

    // Lấy số lượng phiếu nhập kho bị huỷ trong các tháng
    @RequestMapping("/count-cancelled-month")
    public List<Object[]> countCancelledByMonth() {
        return reportInventoryImportService.countCancelledByMonth();
    }

    // Lấy số lượng phiếu nhập kho bị huỷ trong các năm
    @RequestMapping("/count-cancelled-year")
    public List<Object[]> countCancelledByYear() {
        return reportInventoryImportService.countCancelledByYear();
    }
}
