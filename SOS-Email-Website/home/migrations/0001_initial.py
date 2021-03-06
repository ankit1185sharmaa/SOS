# Generated by Django 3.1 on 2020-08-24 15:09

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='NeedyPerson',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('phoneOfNeedy', models.IntegerField()),
                ('messageOfNeedy', models.TextField(max_length=80)),
                ('photoOfNeedy', models.ImageField(upload_to='photoUploads/')),
                ('audioOfNeedy', models.FileField(upload_to='musics/')),
            ],
        ),
    ]
