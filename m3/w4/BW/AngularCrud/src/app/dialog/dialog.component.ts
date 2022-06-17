import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {

  filmForm !: FormGroup;
  actionBtn : string ="Salva"

  constructor(private formBuilder: FormBuilder,
     private api : ApiService,
     @Inject(MAT_DIALOG_DATA) public editData : any,
      private dialogRef : MatDialogRef<DialogComponent>) { }

  ngOnInit(): void {
    this.filmForm = this.formBuilder.group({
      filmName : ['',Validators.required],
      category : ['',Validators.required],
      description : ['',Validators.required]
    });

    if(this.editData){
      this.actionBtn = "Aggiorna";
      this.filmForm.controls['filmName'].setValue(this.editData.filmName);
      this.filmForm.controls['category'].setValue(this.editData.category);
      this.filmForm.controls['description'].setValue(this.editData.description);
    }
  }

  addFilm(){
    if(!this.editData){
      if(this.filmForm.valid){
        this.api.postFilm(this.filmForm.value)
        .subscribe({
          next:(res) => {
            alert("Film aggiunto con successo");
            this.filmForm.reset();
            this.dialogRef.close('save');
          },
          error:()=>{
            alert("Errore durante l'aggiunta del fim")
          }
        })
      }
    }else{
      this.updateFilm()
    }
  }
  updateFilm(){
    this.api.putFilm(this.filmForm.value,this.editData.id)
    .subscribe({
      next:(res) => {
        alert("Film aggiornato con successo");
        this.filmForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("Errore durante la modifica del film")
      }
    })
  }
}
