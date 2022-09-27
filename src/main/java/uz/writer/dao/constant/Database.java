package uz.writer.dao.constant;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import uz.writer.dao.dto.PortLd10Model;
import uz.writer.dao.dto.Report;

import java.util.function.BiFunction;

public class Database {

    private Database() {
    }

    public static final String SELECT_PORT_LD_10_FOR_SINGLE = "select port_ld_10.ld_id,port_ld_10.sbor,port_ld_10.status_name,port_ld_10.n_claim,port_ld_10.req_n_code,port_ld_10.account\n" +
            ",port_ld_10.ids_region  ,port_ld_10.branch_nam  ,port_ld_10.client_name ,port_ld_10.tip_cl,port_ld_10.tip_cl_kod,\n" +
            "port_ld_10.USE_BRANCH,port_ld_10.tax_registr,port_ld_10.birthday,port_ld_10.DISTR,port_ld_10.DISTR_NAME,\n" +
            "port_ld_10.N_ACT_NUM_NEW,port_ld_10.N_ACT_DATE_NEW,port_ld_10.crc_num,port_ld_10.crc_date,port_ld_10.p_num1,port_ld_10.p_date,\n" +
            "port_ld_10.ld_amount,port_ld_10.ld_amount_eqv,port_ld_10.nameguarr,port_ld_10.dist_sum,port_ld_10.dist_sum_eqv,\n" +
            "port_ld_10.dist_sum_y,port_ld_10.dist_sum_y_eqv,port_ld_10.nal_bez,port_ld_10.dat_delay   ,port_ld_10.kol_deb_2,\n" +
            "port_ld_10.soogu       ,port_ld_10.summ_kr     ,port_ld_10.summ_ost_z  ,port_ld_10.summ_ost_ze ,port_ld_10.acc_over,\n" +
            "port_ld_10.summ_ostpr_z,port_ld_10.summ_ostpr_ze,port_ld_10.date_old_pr,port_ld_10.DATE_LAST_3,port_ld_10.ids_val     ,\n" +
            "port_ld_10.sred_name   ,port_ld_10.sred_id,port_ld_10.NAME_FIN,port_ld_10.ABR_source,port_ld_10.target      ,\n" +
            "port_ld_10.kol_work,port_ld_10.shifr_id,port_ld_10.kod_otr,port_ld_10.code_sector_old,port_ld_10.code_sector,\n" +
            "port_ld_10.code_sector_name,port_ld_10.rate,port_ld_10.rate_dog,port_ld_10.date_to_cr  ,port_ld_10.dat_last_db ,\n" +
            "port_ld_10.sum_last_db ,port_ld_10.date_close  ,port_ld_10.pog_tek,port_ld_10.pog_tek_1,port_ld_10.pog_tek_2,\n" +
            "port_ld_10.guar_name   ,port_ld_10.guar_id,port_ld_10.max_guar_id,port_ld_10.sumguarr    ,port_ld_10.sumproc     ,\n" +
            "port_ld_10.sumproc_eqv  ,port_ld_10.date_last_pr,port_ld_10.sumnachpr   ,port_ld_10.sumnachpr_eqv,port_ld_10.dat_l_31,\n" +
            "port_ld_10.summ_nach_pr  ,port_ld_10.summ_nach_pr_s  ,port_ld_10.all_pog,port_ld_10.summprodpr  ,port_ld_10.summprodpr_eqv,\n" +
            "port_ld_10.summproP  ,port_ld_10.summproP_eqv,port_ld_10.date_fin_pr ,port_ld_10.ost_17,port_ld_10.ost_46,port_ld_10.ost_44,\n" +
            "port_ld_10.ost_48,port_ld_10.sum_ost_71_73,port_ld_10.sum_ost_71_73_e,port_ld_10.dat_old_71_73,port_ld_10.p_num       ,\n" +
            "port_ld_10.date_post   ,port_ld_10.klass_name  ,port_ld_10.klass_kod,port_ld_10.summrez     ,port_ld_10.summrez_eqv,\n" +
            "port_ld_10.fio         ,port_ld_10.ss_ld_type_id,port_ld_10.ss_ld_type_name,port_ld_10.ss_credit_id,port_ld_10.ss_credit_name,\n" +
            "port_ld_10.s_credit_kod,port_ld_10.s_credit_name,port_ld_10.SUE_DATE,port_ld_10.DECREE_DATE,port_ld_10.COMMENTARY,\n" +
            "port_ld_10.LAW_ORGANIZATION,port_ld_10.SIGN_OF_DESIGION,port_ld_10.FULL_NAME,port_ld_10.Kur         ,port_ld_10.term_type,\n" +
            "port_ld_10.emp_count,port_ld_10.KOD_INT,port_ld_10.enterp_type_k,port_ld_10.enterp_type_n,port_ld_10.MIN_LD_GR,\n" +
            "port_ld_10.name_actu,port_ld_10.date_actu_close,port_ld_10.fin_cred,port_ld_10.summ_16405,port_ld_10.summ_16413,\n" +
            "port_ld_10.summ_16413_pr,port_ld_10.rate_upr,port_ld_10.calc_method,port_ld_10.reapy_dat,port_ld_10.repay_sum,\n" +
            "port_ld_10.date_cancel,port_ld_10.summ_cancel,port_ld_10.rate_proc,port_ld_10.begin_rate,port_ld_10.Kod_Fin,\n" +
            "port_ld_10.summ_last_3,port_ld_10.acc_v,port_ld_10.s_shifr_nam,port_ld_10.PROD_NAME,port_ld_10.s_branch_nam,\n" +
            "port_ld_10.am_guar_20,port_ld_10.am_guar_21,port_ld_10.am_guar_22,port_ld_10.am_guar_23,port_ld_10.am_guar_24,\n" +
            "port_ld_10.am_guar_25,port_ld_10.am_guar_26,port_ld_10.am_guar_27,port_ld_10.am_guar_28,port_ld_10.am_guar_29,\n" +
            "port_ld_10.am_guar_30,port_ld_10.am_guar_31,port_ld_10.am_guar_32,port_ld_10.am_guar_33,port_ld_10.am_guar_34,\n" +
            "port_ld_10.am_guar_35,port_ld_10.am_guar_36,port_ld_10.am_guar_37,port_ld_10.am_guar_38,port_ld_10.am_guar_39,\n" +
            "port_ld_10.am_guar_40,port_ld_10.am_guar_41,port_ld_10.am_guar_42,port_ld_10.am_guar_43,port_ld_10.am_guar_50,\n" +
            "port_ld_10.am_guar_51,port_ld_10.am_guar_60,port_ld_10.am_guar_61,port_ld_10.dop_1001,port_ld_10.dop_1002,port_ld_10.dop_1003,\n" +
            "port_ld_10.dop_1004,port_ld_10.dop_1005,port_ld_10.dop_1006,port_ld_10.dop_1007,port_ld_10.dop_1008,port_ld_10.dop_1009,\n" +
            "port_ld_10.dop_1010,port_ld_10.dop_1011,port_ld_10.dop_1012,port_ld_10.dop_1013,port_ld_10.dop_1014,port_ld_10.dop_1015,\n" +
            "port_ld_10.dop_1016,port_ld_10.dop_1017,port_ld_10.dop_1018,port_ld_10.dop_1019,port_ld_10.dop_1020,port_ld_10.Summ_lay_pr,\n" +
            "port_ld_10.Summ_lay_pr_eqv,port_ld_10.code_mort,port_ld_10.ACOMP_NAME,port_ld_10.EVAL_REPORT_NUM,port_ld_10.id_ss_subsidiary,\n" +
            "port_ld_10.subsidiary,port_ld_10.summ_nach_pr_nm,port_ld_10.summ_nach_pr_s_nm,port_ld_10.code_bal,port_ld_10.DAT_DELAY_31,\n" +
            "port_ld_10.ID_CLIENT,port_ld_10.ACC_09,port_ld_10.ACC_09_E,port_ld_10.ACCOND_9,port_ld_10.last_db_r,port_ld_10.ahtun_n,\n" +
            "port_ld_10.loan_id,port_ld_10.loan_name,port_ld_10.acc_holi,port_ld_10.holi_sym,port_ld_10.ahtun_n_1,port_ld_10.ahtun_n_2,\n" +
            "port_ld_10.passport_sn from port_ld_10,s_mfo where port_ld_10.date_rep=to_date(:date,'dd.mm.yyyy') and \n" +
            "port_ld_10.branch=s_mfo.bank_id and port_ld_10.branch=:branch and (nvl(port_ld_10.summ_ost_z,0)<>0  or nvl(port_ld_10.summ_ostpr_z,0)<>0  or nvl(port_ld_10.sumproc,0)<>0  or nvl(port_ld_10.sumnachpr,0)<>0\n" +
            "or nvl(port_ld_10.summprodpr,0)<>0  or nvl(port_ld_10.summproP,0)<>0  or nvl(port_ld_10.sum_ost_71_73,0)<>0  or nvl(port_ld_10.summ_16405,0)<>0 )";

    public static final String SELECT_PORT_LD_10_FOR_ALL = "select port_ld_10.ld_id,port_ld_10.sbor,port_ld_10.status_name,port_ld_10.n_claim,port_ld_10.req_n_code,port_ld_10.account\n" +
            ",port_ld_10.ids_region  ,port_ld_10.branch_nam  ,port_ld_10.client_name ,port_ld_10.tip_cl,port_ld_10.tip_cl_kod,\n" +
            "port_ld_10.USE_BRANCH,port_ld_10.tax_registr,port_ld_10.birthday,port_ld_10.DISTR,port_ld_10.DISTR_NAME,\n" +
            "port_ld_10.N_ACT_NUM_NEW,port_ld_10.N_ACT_DATE_NEW,port_ld_10.crc_num,port_ld_10.crc_date,port_ld_10.p_num1,port_ld_10.p_date,\n" +
            "port_ld_10.ld_amount,port_ld_10.ld_amount_eqv,port_ld_10.nameguarr,port_ld_10.dist_sum,port_ld_10.dist_sum_eqv,\n" +
            "port_ld_10.dist_sum_y,port_ld_10.dist_sum_y_eqv,port_ld_10.nal_bez,port_ld_10.dat_delay   ,port_ld_10.kol_deb_2,\n" +
            "port_ld_10.soogu       ,port_ld_10.summ_kr     ,port_ld_10.summ_ost_z  ,port_ld_10.summ_ost_ze ,port_ld_10.acc_over,\n" +
            "port_ld_10.summ_ostpr_z,port_ld_10.summ_ostpr_ze,port_ld_10.date_old_pr,port_ld_10.DATE_LAST_3,port_ld_10.ids_val     ,\n" +
            "port_ld_10.sred_name   ,port_ld_10.sred_id,port_ld_10.NAME_FIN,port_ld_10.ABR_source,port_ld_10.target      ,\n" +
            "port_ld_10.kol_work,port_ld_10.shifr_id,port_ld_10.kod_otr,port_ld_10.code_sector_old,port_ld_10.code_sector,\n" +
            "port_ld_10.code_sector_name,port_ld_10.rate,port_ld_10.rate_dog,port_ld_10.date_to_cr  ,port_ld_10.dat_last_db ,\n" +
            "port_ld_10.sum_last_db ,port_ld_10.date_close  ,port_ld_10.pog_tek,port_ld_10.pog_tek_1,port_ld_10.pog_tek_2,\n" +
            "port_ld_10.guar_name   ,port_ld_10.guar_id,port_ld_10.max_guar_id,port_ld_10.sumguarr    ,port_ld_10.sumproc     ,\n" +
            "port_ld_10.sumproc_eqv  ,port_ld_10.date_last_pr,port_ld_10.sumnachpr   ,port_ld_10.sumnachpr_eqv,port_ld_10.dat_l_31,\n" +
            "port_ld_10.summ_nach_pr  ,port_ld_10.summ_nach_pr_s  ,port_ld_10.all_pog,port_ld_10.summprodpr  ,port_ld_10.summprodpr_eqv,\n" +
            "port_ld_10.summproP  ,port_ld_10.summproP_eqv,port_ld_10.date_fin_pr ,port_ld_10.ost_17,port_ld_10.ost_46,port_ld_10.ost_44,\n" +
            "port_ld_10.ost_48,port_ld_10.sum_ost_71_73,port_ld_10.sum_ost_71_73_e,port_ld_10.dat_old_71_73,port_ld_10.p_num       ,\n" +
            "port_ld_10.date_post   ,port_ld_10.klass_name  ,port_ld_10.klass_kod,port_ld_10.summrez     ,port_ld_10.summrez_eqv,\n" +
            "port_ld_10.fio         ,port_ld_10.ss_ld_type_id,port_ld_10.ss_ld_type_name,port_ld_10.ss_credit_id,port_ld_10.ss_credit_name,\n" +
            "port_ld_10.s_credit_kod,port_ld_10.s_credit_name,port_ld_10.SUE_DATE,port_ld_10.DECREE_DATE,port_ld_10.COMMENTARY,\n" +
            "port_ld_10.LAW_ORGANIZATION,port_ld_10.SIGN_OF_DESIGION,port_ld_10.FULL_NAME,port_ld_10.Kur         ,port_ld_10.term_type,\n" +
            "port_ld_10.emp_count,port_ld_10.KOD_INT,port_ld_10.enterp_type_k,port_ld_10.enterp_type_n,port_ld_10.MIN_LD_GR,\n" +
            "port_ld_10.name_actu,port_ld_10.date_actu_close,port_ld_10.fin_cred,port_ld_10.summ_16405,port_ld_10.summ_16413,\n" +
            "port_ld_10.summ_16413_pr,port_ld_10.rate_upr,port_ld_10.calc_method,port_ld_10.reapy_dat,port_ld_10.repay_sum,\n" +
            "port_ld_10.date_cancel,port_ld_10.summ_cancel,port_ld_10.rate_proc,port_ld_10.begin_rate,port_ld_10.Kod_Fin,\n" +
            "port_ld_10.summ_last_3,port_ld_10.acc_v,port_ld_10.s_shifr_nam,port_ld_10.PROD_NAME,port_ld_10.s_branch_nam,\n" +
            "port_ld_10.am_guar_20,port_ld_10.am_guar_21,port_ld_10.am_guar_22,port_ld_10.am_guar_23,port_ld_10.am_guar_24,\n" +
            "port_ld_10.am_guar_25,port_ld_10.am_guar_26,port_ld_10.am_guar_27,port_ld_10.am_guar_28,port_ld_10.am_guar_29,\n" +
            "port_ld_10.am_guar_30,port_ld_10.am_guar_31,port_ld_10.am_guar_32,port_ld_10.am_guar_33,port_ld_10.am_guar_34,\n" +
            "port_ld_10.am_guar_35,port_ld_10.am_guar_36,port_ld_10.am_guar_37,port_ld_10.am_guar_38,port_ld_10.am_guar_39,\n" +
            "port_ld_10.am_guar_40,port_ld_10.am_guar_41,port_ld_10.am_guar_42,port_ld_10.am_guar_43,port_ld_10.am_guar_50,\n" +
            "port_ld_10.am_guar_51,port_ld_10.am_guar_60,port_ld_10.am_guar_61,port_ld_10.dop_1001,port_ld_10.dop_1002,port_ld_10.dop_1003,\n" +
            "port_ld_10.dop_1004,port_ld_10.dop_1005,port_ld_10.dop_1006,port_ld_10.dop_1007,port_ld_10.dop_1008,port_ld_10.dop_1009,\n" +
            "port_ld_10.dop_1010,port_ld_10.dop_1011,port_ld_10.dop_1012,port_ld_10.dop_1013,port_ld_10.dop_1014,port_ld_10.dop_1015,\n" +
            "port_ld_10.dop_1016,port_ld_10.dop_1017,port_ld_10.dop_1018,port_ld_10.dop_1019,port_ld_10.dop_1020,port_ld_10.Summ_lay_pr,\n" +
            "port_ld_10.Summ_lay_pr_eqv,port_ld_10.code_mort,port_ld_10.ACOMP_NAME,port_ld_10.EVAL_REPORT_NUM,port_ld_10.id_ss_subsidiary,\n" +
            "port_ld_10.subsidiary,port_ld_10.summ_nach_pr_nm,port_ld_10.summ_nach_pr_s_nm,port_ld_10.code_bal,port_ld_10.DAT_DELAY_31,\n" +
            "port_ld_10.ID_CLIENT,port_ld_10.ACC_09,port_ld_10.ACC_09_E,port_ld_10.ACCOND_9,port_ld_10.last_db_r,port_ld_10.ahtun_n,\n" +
            "port_ld_10.loan_id,port_ld_10.loan_name,port_ld_10.acc_holi,port_ld_10.holi_sym,port_ld_10.ahtun_n_1,port_ld_10.ahtun_n_2,\n" +
            "port_ld_10.passport_sn from port_ld_10,s_mfo where port_ld_10.date_rep=to_date(:date,'dd.mm.yyyy') and\n" +
            "port_ld_10.branch=s_mfo.bank_id and s_mfo.region_id in ('03','06','08','10','12','14','18','22','24','26','27','30','33','35')\n" +
            "and s_mfo.HEADER_ID='09051' and (nvl(port_ld_10.summ_ost_z,0)<>0  or nvl(port_ld_10.summ_ostpr_z,0)<>0  or nvl(port_ld_10.sumproc,0)<>0  or nvl(port_ld_10.sumnachpr,0)<>0\n" +
            "or nvl(port_ld_10.summprodpr,0)<>0  or nvl(port_ld_10.summproP,0)<>0  or nvl(port_ld_10.sum_ost_71_73,0)<>0  or nvl(port_ld_10.summ_16405,0)<>0 )";



    public static final String sql = "select client_doc, client_phone, additions_id, user_id, ban_id, code from test";


    public static final BiFunction<Row, RowMetadata, Report> MAPPING =
            (row, rowMetaData) -> Report.builder()
                    .clientDoc(row.get("client_doc", String.class))
                    .clientPhone(row.get("client_phone", String.class))
                    .userId(row.get("user_id", Integer.class))
                    .banId(row.get("ban_id", Integer.class))
                    .code(row.get("code", String.class))
                    .build();




    public static final BiFunction<Row, RowMetadata, PortLd10Model> MAPPING_PORT_LD_10 =
            (row, rowMetadata) -> PortLd10Model.builder()
                    .ldId(row.get("LD_ID", Long.class))
                    .sbor(row.get("SBOR", String.class))
                    .statusName(row.get("STATUS_NAME", String.class))
                    .nClaim(row.get("N_CLAIM", String.class))
                    .reqNCode(row.get("REQ_N_CODE", String.class))
                    .account(row.get("ACCOUNT", String.class))
                    .idsRegion(row.get("IDS_REGION", String.class))
                    .branchNam(row.get("BRANCH_NAM", String.class))
                    .clientName(row.get("CLIENT_NAME", String.class))
                    .tipCl(row.get("TIP_CL", String.class))
                    .tipClKod(row.get("TIP_CL_KOD", String.class))
                    .useBranch(row.get("USE_BRANCH", String.class))
                    .taxRegistr(row.get("TAX_REGISTR", String.class))
                    .birthday(row.get("BIRTHDAY", String.class))
                    .distr(row.get("DISTR", String.class))
                    .distrName(row.get("DISTR_NAME", String.class))
                    .nActNumNew(row.get("N_ACT_NUM_NEW", String.class))
                    .nActDateNew(row.get("N_ACT_DATE_NEW", String.class))
                    .crcNum(row.get("CRC_NUM", String.class))
                    .crcDate(row.get("CRC_DATE", String.class))
                    .pNum1(row.get("P_NUM1", String.class))
                    .pDate(row.get("P_DATE", String.class))
                    .ldAmount(row.get("LD_AMOUNT", Long.class))
                    .ldAmountEqv(row.get("LD_AMOUNT_EQV", Long.class))
                    .nameguarr(row.get("NAMEGUARR", String.class))
                    .distSum(row.get("DIST_SUM", Long.class))
                    .distSumEqv(row.get("DIST_SUM_EQV", Long.class))
                    .distSumY(row.get("DIST_SUM_Y", String.class))
                    .distSumYEqv(row.get("DIST_SUM_Y_EQV", String.class))
                    .nalBez(row.get("NAL_BEZ", Long.class))
                    .datDelay(row.get("DAT_DELAY", String.class))
                    .kolDeb2(row.get("KOL_DEB_2", Long.class))
                    .soogu(row.get("SOOGU", String.class))
                    .summKr(row.get("SUMM_KR", Long.class))
                    .summOstZ(row.get("SUMM_OST_Z", Long.class))
                    .summOstZe(row.get("SUMM_OST_ZE", Long.class))
                    .accOver(row.get("ACC_OVER", String.class))
                    .summOstprZ(row.get("SUMM_OSTPR_Z", Long.class))
                    .summOstprZe(row.get("SUMM_OSTPR_ZE", Long.class))
                    .dateOldPr(row.get("DATE_OLD_PR", String.class))
                    .dateLast3(row.get("DATE_LAST_3", String.class))
                    .idsVal(row.get("IDS_VAL", String.class))
                    .sredName(row.get("SRED_NAME", String.class))
                    .sredId(row.get("SRED_ID", String.class))
                    .nameFin(row.get("NAME_FIN", String.class))
                    .abrSource(row.get("ABR_SOURCE", String.class))
                    .target(row.get("TARGET", String.class))
                    .kolWork(row.get("KOL_WORK", String.class))
                    .shifrId(row.get("SHIFR_ID", String.class))
                    .kodOtr(row.get("KOD_OTR", String.class))
                    .codeSectorOld(row.get("CODE_SECTOR_OLD", String.class))
                    .codeSector(row.get("CODE_SECTOR", String.class))
                    .codeSectorName(row.get("CODE_SECTOR_NAME", String.class))
                    .rate(row.get("RATE", Long.class))
                    .rateDog(row.get("RATE_DOG", Long.class))
                    .dateToCr(row.get("DATE_TO_CR", String.class))
                    .datLastDb(row.get("DAT_LAST_DB", String.class))
                    .sumLastDb(row.get("SUM_LAST_DB", Long.class))
                    .dateClose(row.get("DATE_CLOSE", String.class))
                    .pogTek(row.get("POG_TEK", Long.class))
                    .pogTek1(row.get("POG_TEK_1", Long.class))
                    .pogTek2(row.get("POG_TEK_2", Long.class))
                    .guarName(row.get("GUAR_NAME", String.class))
                    .guarId(row.get("GUAR_ID", String.class))
                    .maxGuarId(row.get("MAX_GUAR_ID", String.class))
                    .sumguarr(row.get("SUMGUARR", Long.class))
                    .sumproc(row.get("SUMPROC", Double.class))
                    .sumprocEqv(row.get("SUMPROC_EQV", Double.class))
                    .dateLastPr(row.get("DATE_LAST_PR", String.class))
                    .sumnachpr(row.get("SUMNACHPR", Double.class))
                    .sumnachprEqv(row.get("SUMNACHPR_EQV", Double.class))
                    .datL31(row.get("DAT_L_31", String.class))
                    .summNachPr(row.get("SUMM_NACH_PR", Double.class))
                    .summNachPrS(row.get("SUMM_NACH_PR_S", Double.class))
                    .allPog(row.get("ALL_POG", Long.class))
                    .summprodpr(row.get("SUMMPRODPR", String.class))
                    .summprodprEqv(row.get("SUMMPRODPR_EQV", String.class))
                    .summprop(row.get("SUMMPROP", String.class))
                    .summpropEqv(row.get("SUMMPROP_EQV", String.class))
                    .dateFinPr(row.get("DATE_FIN_PR", String.class))
                    .ost17(row.get("OST_17", Long.class))
                    .ost46(row.get("OST_46", String.class))
                    .ost44(row.get("OST_44", String.class))
                    .ost48(row.get("OST_48", Long.class))
                    .sumOst7173(row.get("SUM_OST_71_73", String.class))
                    .sumOst7173E(row.get("SUM_OST_71_73_E", String.class))
                    .datOld7173(row.get("DAT_OLD_71_73", String.class))
                    .pNum(row.get("P_NUM", String.class))
                    .datePost(row.get("DATE_POST", String.class))
                    .klassName(row.get("KLASS_NAME", String.class))
                    .klassKod(row.get("KLASS_KOD", String.class))
                    .summrez(row.get("SUMMREZ", Long.class))
                    .summrezEqv(row.get("SUMMREZ_EQV", Long.class))
                    .fio(row.get("FIO", String.class))
                    .ssLdTypeId(row.get("SS_LD_TYPE_ID", Long.class))
                    .ssLdTypeName(row.get("SS_LD_TYPE_NAME", String.class))
                    .ssCreditId(row.get("SS_CREDIT_ID", Long.class))
                    .ssCreditName(row.get("SS_CREDIT_NAME", String.class))
                    .sCreditKod(row.get("S_CREDIT_KOD", String.class))
                    .sCreditName(row.get("S_CREDIT_NAME", String.class))
                    .sueDate(row.get("SUE_DATE", String.class))
                    .decreeDate(row.get("DECREE_DATE", String.class))
                    .commentary(row.get("COMMENTARY", String.class))
                    .lawOrganization(row.get("LAW_ORGANIZATION", String.class))
                    .signOfDesigion(row.get("SIGN_OF_DESIGION", String.class))
                    .fullName(row.get("FULL_NAME", String.class))
                    .kur(row.get("KUR", String.class))
                    .termType(row.get("TERM_TYPE", String.class))
                    .empCount(row.get("EMP_COUNT", String.class))
                    .kodInt(row.get("KOD_INT", String.class))
                    .enterpTypeK(row.get("ENTERP_TYPE_K", Long.class))
                    .enterpTypeN(row.get("ENTERP_TYPE_N", String.class))
                    .minLdGr(row.get("MIN_LD_GR", String.class))
                    .nameActu(row.get("NAME_ACTU", String.class))
                    .dateActuClose(row.get("DATE_ACTU_CLOSE", String.class))
                    .finCred(row.get("FIN_CRED", String.class))
                    .summ16405(row.get("SUMM_16405", String.class))
                    .summ16413(row.get("SUMM_16413", Long.class))
                    .summ16413Pr(row.get("SUMM_16413_PR", String.class))
                    .rateUpr(row.get("RATE_UPR", String.class))
                    .calcMethod(row.get("CALC_METHOD", String.class))
                    .reapyDat(row.get("REAPY_DAT", String.class))
                    .repaySum(row.get("REPAY_SUM", Long.class))
                    .dateCancel(row.get("DATE_CANCEL", String.class))
                    .summCancel(row.get("SUMM_CANCEL", Double.class))
                    .rateProc(row.get("RATE_PROC", Long.class))
                    .beginRate(row.get("BEGIN_RATE", String.class))
                    .kodFin(row.get("KOD_FIN", String.class))
                    .summLast3(row.get("SUMM_LAST_3", Long.class))
                    .accV(row.get("ACC_V", String.class))
                    .sShifrNam(row.get("S_SHIFR_NAM", String.class))
                    .prodName(row.get("PROD_NAME", String.class))
                    .sBranchNam(row.get("S_BRANCH_NAM", String.class))
                    .amGuar20(row.get("AM_GUAR_20", Long.class))
                    .amGuar21(row.get("AM_GUAR_21", Long.class))
                    .amGuar22(row.get("AM_GUAR_22", Long.class))
                    .amGuar23(row.get("AM_GUAR_23", Long.class))
                    .amGuar24(row.get("AM_GUAR_24", Long.class))
                    .amGuar25(row.get("AM_GUAR_25", Long.class))
                    .amGuar26(row.get("AM_GUAR_26", Long.class))
                    .amGuar27(row.get("AM_GUAR_27", Long.class))
                    .amGuar28(row.get("AM_GUAR_28", Long.class))
                    .amGuar29(row.get("AM_GUAR_29", Long.class))
                    .amGuar30(row.get("AM_GUAR_30", Long.class))
                    .amGuar31(row.get("AM_GUAR_31", Long.class))
                    .amGuar32(row.get("AM_GUAR_32", Long.class))
                    .amGuar33(row.get("AM_GUAR_33", Long.class))
                    .amGuar34(row.get("AM_GUAR_34", Long.class))
                    .amGuar35(row.get("AM_GUAR_35", Long.class))
                    .amGuar36(row.get("AM_GUAR_36", Long.class))
                    .amGuar37(row.get("AM_GUAR_37", Long.class))
                    .amGuar38(row.get("AM_GUAR_38", Long.class))
                    .amGuar39(row.get("AM_GUAR_39", Long.class))
                    .amGuar40(row.get("AM_GUAR_40", Long.class))
                    .amGuar41(row.get("AM_GUAR_41", Long.class))
                    .amGuar42(row.get("AM_GUAR_42", Long.class))
                    .amGuar43(row.get("AM_GUAR_43", Long.class))
                    .amGuar50(row.get("AM_GUAR_50", Long.class))
                    .amGuar51(row.get("AM_GUAR_51", Long.class))
                    .amGuar60(row.get("AM_GUAR_60", Long.class))
                    .amGuar61(row.get("AM_GUAR_61", Long.class))
                    .dop1001(row.get("DOP_1001", String.class))
                    .dop1002(row.get("DOP_1002", String.class))
                    .dop1003(row.get("DOP_1003", String.class))
                    .dop1004(row.get("DOP_1004", String.class))
                    .dop1005(row.get("DOP_1005", String.class))
                    .dop1006(row.get("DOP_1006", String.class))
                    .dop1007(row.get("DOP_1007", String.class))
                    .dop1008(row.get("DOP_1008", String.class))
                    .dop1009(row.get("DOP_1009", String.class))
                    .dop1010(row.get("DOP_1010", String.class))
                    .dop1011(row.get("DOP_1011", String.class))
                    .dop1012(row.get("DOP_1012", String.class))
                    .dop1013(row.get("DOP_1013", String.class))
                    .dop1014(row.get("DOP_1014", String.class))
                    .dop1015(row.get("DOP_1015", String.class))
                    .dop1016(row.get("DOP_1016", String.class))
                    .dop1017(row.get("DOP_1017", String.class))
                    .dop1018(row.get("DOP_1018", String.class))
                    .dop1019(row.get("DOP_1019", String.class))
                    .dop1020(row.get("DOP_1020", String.class))
                    .summLayPr(row.get("SUMM_LAY_PR", Long.class))
                    .summLayPrEqv(row.get("SUMM_LAY_PR_EQV", Long.class))
                    .codeMort(row.get("CODE_MORT", String.class))
                    .acompName(row.get("ACOMP_NAME", String.class))
                    .evalReportNum(row.get("EVAL_REPORT_NUM", String.class))
                    .idSsSubsidiary(row.get("ID_SS_SUBSIDIARY", String.class))
                    .subsidiary(row.get("SUBSIDIARY", String.class))
                    .summNachPrNm(row.get("SUMM_NACH_PR_NM", Double.class))
                    .summNachPrSNm(row.get("SUMM_NACH_PR_S_NM", Double.class))
                    .codeBal(row.get("CODE_BAL", String.class))
                    .datDelay31(row.get("DAT_DELAY_31", String.class))
                    .idClient(row.get("ID_CLIENT", String.class))
                    .acc09(row.get("ACC_09", String.class))
                    .acc09E(row.get("ACC_09_E", String.class))
                    .accond9(row.get("ACCOND_9", String.class))
                    .lastDbR(row.get("LAST_DB_R", String.class))
                    .ahtunN(row.get("AHTUN_N", String.class))
                    .loanId(row.get("LOAN_ID", Long.class))
                    .loanName(row.get("LOAN_NAME", String.class))
                    .accHoli(row.get("ACC_HOLI", String.class))
                    .holiSym(row.get("HOLI_SYM", String.class))
                    .ahtunN1(row.get("AHTUN_N_1", String.class))
                    .ahtunN2(row.get("AHTUN_N_2", String.class))
                    .passportSn(row.get("PASSPORT_SN", String.class))
                    .build();





}
