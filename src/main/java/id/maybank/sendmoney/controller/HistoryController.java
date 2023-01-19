package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.HistoryTransfer;
import id.maybank.sendmoney.service.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/histories")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public String index(Model model) {

        List<HistoryTransfer> histories = this.historyService.getAllHistories();
        model.addAttribute("histories", histories);
        return "histories";
    }

}
