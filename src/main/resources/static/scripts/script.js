document.addEventListener('DOMContentLoaded', () => {

    /*<![CDATA[*/
        var baseUrl = /*[[@{/}]]*/ "";
    /*]]>*/


    const linkRek = document.getElementById("linkRekPengirim");
    const selectRek = document.getElementById("selRekPengirim");

    selectRek.addEventListener("input", (evt) => {

      let optionRek = evt.target.options;

      let norek = optionRek[optionRek.selectedIndex].text;
      cekNorek(norek)
      console.log(norek)

    })

    linkRek.addEventListener("click", (evt) => {
      // evt.preventDefault();
      cekNorek();

    })

    function cekNorek(norek) {

      // norek awal
      if (!norek) {

        let rekAwal = selectRek.options[selectRek.options.selectedIndex].text;
        linkRek.setAttribute("href", "/cek-rek/"+rekAwal);

        return
      }

      linkRek.setAttribute("href", "/cek-rek/"+norek);

    }


  (document.querySelectorAll('.notification .delete') || []).forEach(del => {
    const notification = del.parentNode;

    del.addEventListener('click', () => {
      notification.parentNode.removeChild(notification);
    });
  });


});

console.log("ini js");